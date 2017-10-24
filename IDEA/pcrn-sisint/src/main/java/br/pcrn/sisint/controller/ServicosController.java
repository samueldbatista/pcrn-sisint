package br.pcrn.sisint.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.DefaultValidator;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.pcrn.sisint.anotacoes.Transacional;
import br.pcrn.sisint.dao.ServicoDao;
import br.pcrn.sisint.dao.UsuarioDAO;
import br.pcrn.sisint.dominio.*;
import br.pcrn.sisint.negocio.ServicosNegocio;
import br.pcrn.sisint.util.OpcaoSelect;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ServicosController {

    private Result result;
    private ServicoDao servicoDao;
    private Validator validador;
    private UsuarioDAO usuarioDAO;
    private ServicosNegocio servicosNegocio;

    private List<Tarefa> tarefas1 = new ArrayList<>();

    /**
     * @deprecated CDI eyes only
     */
    protected ServicosController() {
        this(null,null, null, null, null);
    }

    @Inject
    public ServicosController(Result result, ServicoDao servicoDao, Validator validador, UsuarioDAO usuarioDAO,
                              ServicosNegocio servicosNegocio) {
        this.result = result;
        this.servicoDao = servicoDao;
        this.validador =  validador;
        this.usuarioDAO= usuarioDAO;
        this.servicosNegocio = servicosNegocio;
    }

    public void form() {
        result.include("usuarios", servicosNegocio.geraListaOpcoesUsuarios());
        result.include("setores", servicosNegocio.geraListaOpcoesSetor());
        result.include("status", OpcaoSelect.toListaOpcoes(StatusServico.values()));
        result.include("statusTarefa", OpcaoSelect.toListaOpcoes(StatusTarefa.values()));
        result.include("prioridades", OpcaoSelect.toListaOpcoes(Prioridade.values()));
    }

    @Post("/servicos")
    @Transacional
    public void salvar(Servico servico) {
        if(servico != null){
            servico.setDataAbertura(LocalDate.now());
        }
        if(servico.getTitulo() == null){
            validador.add( new SimpleMessage("titulo", "Titulo é obrigatório"));
        }

        validador.onErrorRedirectTo(this).form();
        this.servicoDao.salvar(servico);
        result.redirectTo((this)).lista();
    }
    public void salvarTarefa(Tarefa tarefa){
        tarefas1.add(tarefa);
        result.nothing();
    }
    public void lista() {

        List<Servico> servicos = this.servicoDao.listarServicos();
        result.include("servicos", servicos);
    }

    public void editar(Long id){
        Servico  servico = this.servicoDao.BuscarPorId(id);
        result.include("setores", servicosNegocio.geraListaOpcoesSetor());
        result.include("usuarios", servicosNegocio.geraListaOpcoesUsuarios());
        result.include("status", OpcaoSelect.toListaOpcoes(StatusServico.values()));
        result.include("statusTarefa",OpcaoSelect.toListaOpcoes(StatusTarefa.values()));
        result.include("prioridades", OpcaoSelect.toListaOpcoes(Prioridade.values()));
        result.include(servico);
        result.of(this).form();
    }
}

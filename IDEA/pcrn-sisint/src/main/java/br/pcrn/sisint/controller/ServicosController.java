package br.pcrn.sisint.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.validator.DefaultValidator;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.pcrn.sisint.anotacoes.Seguranca;
import br.pcrn.sisint.anotacoes.Transacional;
import br.pcrn.sisint.dao.ServicoDao;
import br.pcrn.sisint.dao.UsuarioDAO;
import br.pcrn.sisint.dominio.*;
import br.pcrn.sisint.negocio.ServicosNegocio;
import br.pcrn.sisint.util.OpcaoSelect;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Seguranca(tipoUsuario = TipoUsuario.TECNICO)
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
        servico.setStatusServico(StatusServico.EM_ESPERA);
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

    @Get
//    @Path("/listaTarefas/{id}")
    public void listaTarefas(Long id) {
        Servico servico = servicoDao.BuscarPorId(id);
        JsonArray listaServicos = new JsonArray();
        if(servico != null) {
            for (Tarefa tarefa: servico.getTarefas()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("id", tarefa.getId());
                jsonObject.addProperty("Titulo", tarefa.getTitulo());
                jsonObject.addProperty("status", tarefa.getStatusTarefa().getChave());
                jsonObject.addProperty("descricao", tarefa.getDescricao());
                jsonObject.addProperty("servicoId", tarefa.getServico().getId());
                jsonObject.addProperty("tecnicoId", tarefa.getTecnico().getId());
                listaServicos.add(jsonObject);
            }
            result.use(Results.json()).withoutRoot().from(listaServicos).recursive().serialize();
        } else {

        }

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

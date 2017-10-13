package br.pcrn.sisint.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.DefaultValidator;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.pcrn.sisint.anotacoes.Transacional;
import br.pcrn.sisint.dao.ServicoDao;
import br.pcrn.sisint.dominio.Servico;
import br.pcrn.sisint.dominio.StatusServico;
import br.pcrn.sisint.dominio.StatusTarefa;
import br.pcrn.sisint.dominio.Usuario;
import br.pcrn.sisint.util.OpcaoSelect;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ServicosController {

    private Result result;
    private ServicoDao servicoDao;
    private Validator validador;

    /**
     * @deprecated CDI eyes only
     */
    protected ServicosController() {
        this(null, null, null);
    }

    @Inject
    public ServicosController(Result result, ServicoDao servicoDao, Validator validador) {
        this.result = result;
        this.servicoDao = servicoDao;
        this.validador =  validador;
    }

    public void form() {

        result.include("status", OpcaoSelect.toListaOpcoes(StatusServico.values()));
        result.include("statusTarefa", OpcaoSelect.toListaOpcoes(StatusTarefa.values()));
    }

    @Post("/servicos")
    @Transacional
    public void salvar(Servico servico) {

        if(servico.getTitulo() == null){
            validador.add( new SimpleMessage("titulo", "Titulo é obrigatório"));
        }

        validador.onErrorRedirectTo(this).form();
        this.servicoDao.salvar(servico);
        this.result.redirectTo((this)).lista();
    }

    public void lista() {

        List<Servico> servicos = this.servicoDao.listarServicos();
        result.include("servicos", servicos);
    }

    public void editar(Long id){
        Servico  servico = this.servicoDao.BuscarPorId(id);
        result.include("status", OpcaoSelect.toListaOpcoes(StatusServico.values()));
        result.include("statusTarefa",OpcaoSelect.toListaOpcoes(StatusTarefa.values()));
        result.include(servico);
        result.of(this).form();
    }
}

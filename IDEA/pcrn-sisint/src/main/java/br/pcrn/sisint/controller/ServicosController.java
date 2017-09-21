package br.pcrn.sisint.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.DefaultValidator;
import br.com.caelum.vraptor.validator.Validator;
import br.pcrn.sisint.anotacoes.Transacional;
import br.pcrn.sisint.dao.ServicoDao;
import br.pcrn.sisint.dominio.Servico;
import br.pcrn.sisint.dominio.Usuario;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ServicosController {

    private Result result;
    private ServicoDao servicoDao;
    /**
     * @deprecated CDI eyes only
     */
    protected ServicosController() {
        this(null, null);
    }

    @Inject
    public ServicosController(Result result, ServicoDao servicoDao) {
        this.result = result;
        this.servicoDao = servicoDao;
    }

    public void form() {

    }

    @Post("/servicos")
    @Transacional
    public void salvar(Servico servico) {

        this.servicoDao.salvar(servico);
        this.result.redirectTo("/servicos/lista");
    }

    public void lista() {

        List<Servico> servicos = this.servicoDao.listarServicos();
        result.include("servicos", servicos);
    }
}

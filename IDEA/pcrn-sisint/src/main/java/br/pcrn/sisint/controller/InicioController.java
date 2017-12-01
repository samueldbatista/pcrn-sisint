package br.pcrn.sisint.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.pcrn.sisint.anotacoes.Seguranca;
import br.pcrn.sisint.dao.ServicoDao;
import br.pcrn.sisint.dao.TarefaDao;
import br.pcrn.sisint.dominio.StatusServico;
import br.pcrn.sisint.dominio.TipoUsuario;

import javax.inject.Inject;
@Path("/")
@Seguranca(tipoUsuario = TipoUsuario.TECNICO)
@Controller
public class InicioController {

    private Result result;
    private ServicoDao servicoDao;
    private TarefaDao tarefaDao;

    protected InicioController() {
        this(null,null,null);
    }

    @Inject
    public InicioController(Result result, ServicoDao servicoDao, TarefaDao tarefaDao) {
        this.result = result;
        this.servicoDao = servicoDao;
        this.tarefaDao = tarefaDao;
    }

    @Path("")
    public void index(){
        result.include("totalServicos",servicoDao.contarTotalServicos());
        result.include("servicosAbertos",servicoDao.contarServicosStatus(StatusServico.EM_ESPERA));
        result.include("servicosExecucao",servicoDao.contarServicosStatus(StatusServico.EM_EXECUCAO));
        result.include("totalTarefas",tarefaDao.contarTotalTarefas());
    }
}

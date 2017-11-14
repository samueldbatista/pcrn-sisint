package br.pcrn.sisint.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.pcrn.sisint.dao.TarefaDao;
import br.pcrn.sisint.dominio.Tarefa;

import javax.inject.Inject;
import java.util.List;

@Controller
public class TarefasController extends ControladorSisInt {

    private TarefaDao tarefaDao;

    public TarefasController() {
        this(null, null);
    }

    @Inject
    public TarefasController(Result resultado, TarefaDao tarefaDao) {
        super(resultado);
        this.tarefaDao = tarefaDao;
    }

    public void form(){}

    public void salvar() {

    }
    public void editar() {

    }
    public void remover() {

    }

    public void listar(){
        this.resultado.include("tarefas", tarefaDao.todos());
    }

    public void minhasTarefas () {
        List<Tarefa> minhasTarefas =  tarefaDao.minhasTarefas();
        resultado.include("tarefas", minhasTarefas);
    }

    public void tarefasAbertas () {
        List<Tarefa> tarefasAbertas =  tarefaDao.tarefasEmAberto();
        resultado.include("tarefas", tarefasAbertas);
    }


}

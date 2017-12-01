package br.pcrn.sisint.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.pcrn.sisint.anotacoes.Transacional;
import br.pcrn.sisint.dao.TarefaDao;
import br.pcrn.sisint.dao.UsuarioDAO;
import br.pcrn.sisint.dominio.StatusTarefa;
import br.pcrn.sisint.dominio.Tarefa;
import br.pcrn.sisint.dominio.Usuario;
import br.pcrn.sisint.util.OpcaoSelect;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TarefasController extends ControladorSisInt {

    private TarefaDao tarefaDao;
    @Inject
    private UsuarioDAO usuarioDAO;

    public TarefasController() {
        this(null, null);
    }

    @Inject
    public TarefasController(Result resultado, TarefaDao tarefaDao) {
        super(resultado);
        this.tarefaDao = tarefaDao;
    }

    public void form(){
        resultado.include("status", OpcaoSelect.toListaOpcoes(StatusTarefa.values()));
        resultado.include("usuarios", geraListaOpcoesUsuarios());
    }

    public List<OpcaoSelect> geraListaOpcoesUsuarios() {
        List<Usuario> todos = this.usuarioDAO.todos();
        return todos.stream().map(
                usuario -> new OpcaoSelect(usuario.getNome(), usuario.getId()))
                .collect(Collectors.toList());
    }

    @Transacional
    public void salvar(Tarefa tarefa) {
        tarefaDao.salvar(tarefa);
        resultado.redirectTo(InicioController.class).index();
    }
    public void editar(Long id) {
        Tarefa tarefa = tarefaDao.buscarPorId(id);
        resultado.include("tarefa",tarefa);
        resultado.include("status", OpcaoSelect.toListaOpcoes(StatusTarefa.values()));
        resultado.include("usuarios", geraListaOpcoesUsuarios());
        resultado.of(this).form();
    }

    public void remover() {

    }

    public void lista(){
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

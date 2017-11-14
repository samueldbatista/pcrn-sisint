package br.pcrn.sisint.dao;

import br.pcrn.sisint.dominio.Tarefa;

import java.util.List;

public interface TarefaDao {
    void salvar(Tarefa tarefa);
    List<Tarefa> todos();
    List<Tarefa> tarefasEmAberto();
    List<Tarefa> minhasTarefas();

}

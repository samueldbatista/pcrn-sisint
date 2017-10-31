package br.pcrn.sisint.dao;

import br.pcrn.sisint.dominio.Tarefa;

import java.util.List;

public interface TarefaDao {
    public void salvar(Tarefa tarefa);
    public List<Tarefa> listar();
}

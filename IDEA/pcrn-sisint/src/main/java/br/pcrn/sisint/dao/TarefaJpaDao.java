package br.pcrn.sisint.dao;

import br.pcrn.sisint.dominio.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class TarefaJpaDao implements TarefaDao{

    private EntityManager manager;

    @Override
    public void salvar(Tarefa tarefa) {
        if(tarefa.getId() > 0) {
            manager.merge(tarefa);
        } else {
            manager.persist(tarefa);
        }

    }

    @Override
    public List<Tarefa> listar() {
        Query query = this.manager.createQuery("SELECT p FROM Tarefa p WHERE p.deletado = false");
        List<Tarefa> tarefas = query.getResultList();
        return tarefas;
    }
}

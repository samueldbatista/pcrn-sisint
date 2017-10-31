package br.pcrn.sisint.dao;

import br.pcrn.sisint.dominio.Servico;
import br.pcrn.sisint.dominio.Tarefa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by samue on 17/09/2017.
 */
public class ServicoJpaDao implements ServicoDao {

    @Inject
    EntityManager manager;

    @Override
    public void salvar(Servico servico) {
        if(servico.getTarefas() != null){
            referenciarTarefas(servico);
        }
        this.manager.merge(servico);
    }

    private void referenciarTarefas(Servico servico) {
        List<Tarefa> tarefas = servico.getTarefas();
        for (Tarefa tarefa: tarefas) {
            if(tarefa.getServico() == null) {
                tarefa.setServico(servico);
            }
        }
    }

    @Override
    public List<Servico> listarServicos() {
        Query query = manager.createQuery("select s from Servico s where s.deletado = false");


        return query.getResultList();
    }

    @Override
    public Servico BuscarPorId(Long id) {
        Query query = manager.createQuery("select s from Servico s where s.id = :id");

        query.setParameter("id", id);
        return (Servico) query.getSingleResult();
    }
}

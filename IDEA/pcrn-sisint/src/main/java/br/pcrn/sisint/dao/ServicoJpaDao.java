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
        this.manager.persist(servico);
    }

//    private void referenciarServicos(Servico servico){
//        List<Tarefa> tarefas = servico.getTarefas();
//
//        if(tarefas != null){
//            for (Tarefa t: tarefas) {
//                if(t.getServico() !=  null) {
//                    t.setServico(null);
//                }
//                t.setServico(servico);
//            }
//
//        }
//    }

    @Override
    public List<Servico> listarServicos() {
        Query query = manager.createQuery("select s from Servico s where s.deletado = false");


        return query.getResultList();
    }
}

package br.pcrn.sisint.dao;

import br.pcrn.sisint.dominio.Setor;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class SetorJpaDao implements SetorDao{
    private EntityManager manager;

    /**
     * @deprecated CDI
     */
    @Deprecated
    public SetorJpaDao() {
        this(null);
    }

    @Inject
    public SetorJpaDao(EntityManager entityManager) {
        this.manager = entityManager;
    }


    @Override
    public List<Setor> todos() {
        Query query = this.manager.createQuery("SELECT p FROM Setor p where p.deletado = false");

        return query.getResultList();
    }

}

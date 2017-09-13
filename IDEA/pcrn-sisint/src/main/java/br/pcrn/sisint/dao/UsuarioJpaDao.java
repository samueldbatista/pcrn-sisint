package br.pcrn.sisint.dao;

import br.pcrn.sisint.dominio.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by samue on 08/09/2017.
 */
public class UsuarioJpaDao implements UsuarioDao{

    private EntityManager manager;

    /**
     * @deprecated CDI
     */
    @Deprecated
    public UsuarioJpaDao() {
        this(null);
    }

    @Inject
    public UsuarioJpaDao(EntityManager entityManager) {
        this.manager = entityManager;
    }

    @Override
    public void salvar(Usuario usuario) {
        if(usuario.getId() != null) {
            this.manager.merge(usuario);
        } else {
            this.manager.persist(usuario);
        }
    }

    @Override
    public void buscar() {

    }

    @Override
    public void remover() {

    }
}

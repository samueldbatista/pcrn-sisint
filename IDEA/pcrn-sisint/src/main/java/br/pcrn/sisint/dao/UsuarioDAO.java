package br.pcrn.sisint.dao;

import br.pcrn.sisint.dominio.Usuario;

/**
 * Created by samue on 08/09/2017.
 */
public interface UsuarioDAO {

    public void salvar(Usuario usuario);
    public void buscarPorId();
    public Usuario buscarPorLogin(String login);
    public void remover();
}

package br.pcrn.sisint.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.sisint.anotacoes.Transacional;
import br.pcrn.sisint.dao.UsuarioDAO;
import br.pcrn.sisint.dominio.Usuario;

import javax.inject.Inject;

/**
 * Created by samue on 09/09/2017.
 */
@Controller
public class UsuariosController {

    Result result;
    UsuarioDAO usuarioDAO;

    /**
     * @deprecated CDI eyes only
     */
    protected UsuariosController() {
        this(null, null);
    }

    @Inject
    public UsuariosController(UsuarioDAO usuarioDAO, Result result) {
        this.usuarioDAO = usuarioDAO;
        this.result = result;
    }

    public void form(){

    }

    @Post("/usuarios")
    @Transacional
    public void salvar(Usuario usuario){
        this.usuarioDAO.salvar(usuario);
        result.of(this).form();
    }

}

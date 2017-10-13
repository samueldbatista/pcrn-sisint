package br.pcrn.sisint.controller;

import br.com.caelum.vraptor.*;
import br.pcrn.sisint.dao.UsuarioDAO;
import br.pcrn.sisint.dominio.Usuario;
import br.pcrn.sisint.dominio.UsuarioLogado;

import javax.inject.Inject;
@Path("/login")
@Controller
public class LoginController {

    UsuarioLogado usuarioLogado;
    Result resultado;
    UsuarioDAO usuarioDao;

    @Deprecated
    LoginController(){}

    @Inject
    public LoginController(UsuarioLogado usuarioLogado, Result resultado, UsuarioDAO usuarioDAO) {
        this.usuarioLogado = usuarioLogado;
        this.resultado = resultado;
        this.usuarioDao = usuarioDAO;
    }

    @Post("/login")
    public void login(Usuario usuario){
        Usuario usuarioLogin = usuarioDao.buscarPorLogin(usuario.getLogin());
    }

    @Get("/login")
    public void form(){

    }

    @Get("/logout")
    public void logout(){
        this.usuarioLogado.desloga();
    }
}

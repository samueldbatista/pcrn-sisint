package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.sisint.anotacoes.Transacional;
import br.pcrn.sisint.dao.UsuarioDAO;
import br.pcrn.sisint.dominio.Usuario;

@Controller
public class IndexController {

	private final Result result;
	private final UsuarioDAO usuarioDAO;
	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null, null);
	}
	
	@Inject
	public IndexController(Result result, UsuarioDAO usuarioDAO) {
		this.result = result;
		this.usuarioDAO = usuarioDAO;
	}

	@Path("/")
	public void index() {
		result.include("variable", "VRaptor!");
	}

	@Path("/teste")
	public void teste(){
	}
//	@Path("/salvar")
	public void salvar(Usuario usuario){
		this.usuarioDAO.salvar(usuario);
		this.result.of(this).teste();
	}

	public void lista() {

	}
}
package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.pcrn.sisint.anotacoes.Transacional;
import br.pcrn.sisint.dao.UsuarioDao;
import br.pcrn.sisint.dominio.TipoUsuario;
import br.pcrn.sisint.dominio.Usuario;

import java.time.LocalDateTime;

@Controller
public class IndexController {

	private final Result result;
	private final UsuarioDao usuarioDao;
	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null, null);
	}
	
	@Inject
	public IndexController(Result result, UsuarioDao usuarioDao) {
		this.result = result;
		this.usuarioDao = usuarioDao;
	}

	@Path("/")
	public void index() {
		result.include("variable", "VRaptor!");
	}

	@Path("/teste")
	public void teste(){
	}
	@Path("/salvar")
	@Transacional
	public void salvar(Usuario usuario){
		this.usuarioDao.salvar(usuario);
		this.result.of(this).teste();
	}

	public void lista() {

	}
}
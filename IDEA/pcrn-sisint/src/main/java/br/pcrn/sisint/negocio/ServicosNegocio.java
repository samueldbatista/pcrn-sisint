package br.pcrn.sisint.negocio;

import br.pcrn.sisint.dao.ServicoDao;
import br.pcrn.sisint.dao.SetorDao;
import br.pcrn.sisint.dao.UsuarioDAO;
import br.pcrn.sisint.dominio.Servico;
import br.pcrn.sisint.dominio.Setor;
import br.pcrn.sisint.dominio.Usuario;
import br.pcrn.sisint.util.OpcaoSelect;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ServicosNegocio {
    private ServicoDao servicoDao;
    private SetorDao setorDao;
    private UsuarioDAO usuarioDAO;

    public ServicosNegocio(){
        this(null, null,null);
    }

    @Inject
    public ServicosNegocio(ServicoDao servicoDao, UsuarioDAO usuarioDAO,SetorDao setorDao) {
        this.servicoDao = servicoDao;
        this.usuarioDAO = usuarioDAO;
        this.setorDao = setorDao;
    }

    public List<OpcaoSelect> geraListaOpcoesUsuarios() {
        List<Usuario> todos = this.usuarioDAO.todos();
        return todos.stream().map(
                usuario -> new OpcaoSelect(usuario.getNome(), usuario.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesSetor() {
        List<Setor> todos = this.setorDao.todos();
        return todos.stream().map(
                setor -> new OpcaoSelect(setor.getNome(), setor.getId()))
                .collect(Collectors.toList());
    }
}

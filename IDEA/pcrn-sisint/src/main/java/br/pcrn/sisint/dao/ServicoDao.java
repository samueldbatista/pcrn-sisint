package br.pcrn.sisint.dao;

import br.pcrn.sisint.dominio.Servico;

import java.util.List;

/**
 * Created by samue on 17/09/2017.
 */
public interface ServicoDao {
    void salvar(Servico servico);
    List<Servico> listarServicos();
    public List<Servico> listarMeusServicos(Long id);
    public List<Servico> listarServicosEmAberto();
    Servico BuscarPorId(Long id);
    Long ultimoId();
}

package br.pcrn.sisint.dao;

import br.pcrn.sisint.dominio.Servico;

import java.util.List;

/**
 * Created by samue on 17/09/2017.
 */
public interface ServicoDao {
    public void salvar (Servico servico);
    public List<Servico> listarServicos();
}

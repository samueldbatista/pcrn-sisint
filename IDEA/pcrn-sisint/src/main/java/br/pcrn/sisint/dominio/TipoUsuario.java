package br.pcrn.sisint.dominio;

import br.pcrn.sisint.conversor.ConvertivelOpcaoSelect;

/**
 * Created by samue on 08/09/2017.
 */
public enum TipoUsuario implements ConvertivelOpcaoSelect {
    CLIENTE("Cliente"), ADMINISTRADOR("Administrador"), TECNICO("Técnico");

    private String chave;

    TipoUsuario(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

    public String getValor() {
        return this.toString();
    }
}

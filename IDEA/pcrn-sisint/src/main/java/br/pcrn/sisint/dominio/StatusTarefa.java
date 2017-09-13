package br.pcrn.sisint.dominio;

/**
 * Created by samue on 09/09/2017.
 */
public enum StatusTarefa {
    CANCELADO("Cancelado"), EM_ESPERA("Aguardando execução"), EM_EXECUCAO("Em execução"), CONCLUIDO("Concluído");

    private String chave;

    StatusTarefa(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

    public String getValor() {
        return this.toString();
    }

}

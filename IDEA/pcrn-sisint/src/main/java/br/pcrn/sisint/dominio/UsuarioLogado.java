package br.pcrn.sisint.dominio;


import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UsuarioLogado implements Serializable{
    private Usuario usuario;

    public void loga(Usuario usuario){
        this.usuario = usuario;
    }

    public boolean isLogado() {
        return this.usuario != null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void desloga(){
        this.usuario = null;
    }
}

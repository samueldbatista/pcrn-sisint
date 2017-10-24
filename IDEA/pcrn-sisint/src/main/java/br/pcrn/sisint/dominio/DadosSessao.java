package br.pcrn.sisint.dominio;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class DadosSessao implements Serializable {

    private List<Tarefa> tarefasSessao = new ArrayList<>();

    public List<Tarefa> getTarefasSessao() {
        return tarefasSessao;
    }

    public void setTarefasSessao(List<Tarefa> tarefasSessao) {
        this.tarefasSessao = tarefasSessao;
    }
}

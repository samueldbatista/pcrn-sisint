package br.pcrn.sisint.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by samue on 09/09/2017.
 */
//@Entity
public class Tarefa {
//    @Id
//    @GeneratedValue
    private Long id;

//    @OneToOne(fetch = FetchType.EAGER)
    private Usuario tecnicoResponsavel;

//    @ManyToOne(fetch = FetchType.EAGER)
    private Servico servico;

    private String descricao;

    private Long codigoTarefa;

    private StatusTarefa statusTarefa;

    private LocalDateTime prazo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(Usuario tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCodigoTarefa() {
        return codigoTarefa;
    }

    public void setCodigoTarefa(Long codigoTarefa) {
        this.codigoTarefa = codigoTarefa;
    }

    public StatusTarefa getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(StatusTarefa statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tarefa tarefa = (Tarefa) o;

        if (getId() != null ? !getId().equals(tarefa.getId()) : tarefa.getId() != null) return false;
        if (getTecnicoResponsavel() != null ? !getTecnicoResponsavel().equals(tarefa.getTecnicoResponsavel()) : tarefa.getTecnicoResponsavel() != null)
            return false;
        if (getDescricao() != null ? !getDescricao().equals(tarefa.getDescricao()) : tarefa.getDescricao() != null)
            return false;
        if (getCodigoTarefa() != null ? !getCodigoTarefa().equals(tarefa.getCodigoTarefa()) : tarefa.getCodigoTarefa() != null)
            return false;
        if (getStatusTarefa() != tarefa.getStatusTarefa()) return false;
        return getPrazo() != null ? getPrazo().equals(tarefa.getPrazo()) : tarefa.getPrazo() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTecnicoResponsavel() != null ? getTecnicoResponsavel().hashCode() : 0);
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        result = 31 * result + (getCodigoTarefa() != null ? getCodigoTarefa().hashCode() : 0);
        result = 31 * result + (getStatusTarefa() != null ? getStatusTarefa().hashCode() : 0);
        result = 31 * result + (getPrazo() != null ? getPrazo().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", tecnicoResponsavel=" + tecnicoResponsavel +
                ", descricao='" + descricao + '\'' +
                ", codigoTarefa=" + codigoTarefa +
                ", statusTarefa=" + statusTarefa +
                ", prazo=" + prazo +
                '}';
    }
}

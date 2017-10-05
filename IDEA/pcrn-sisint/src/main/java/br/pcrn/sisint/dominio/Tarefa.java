package br.pcrn.sisint.dominio;

import javax.persistence.*;

/**
 * Created by samue on 09/09/2017.
 */
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
//    @OneToOne(fetch = FetchType.EAGER)
//    private Usuario tecnicoResponsavel;

    private String tecnico;

    @ManyToOne(fetch = FetchType.EAGER)
    private Servico servico;

    private String descricao;

    private Long codigoTarefa;

    private StatusTarefa statusTarefa;

    private String prazo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Usuario getTecnicoResponsavel() {
//        return tecnicoResponsavel;
//    }

//    public void setTecnicoResponsavel(Usuario tecnicoResponsavel) {
//        this.tecnicoResponsavel = tecnicoResponsavel;
//    }

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

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
//        result = 31 * result + (getTecnicoResponsavel() != null ? getTecnicoResponsavel().hashCode() : 0);
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
//                ", tecnicoResponsavel=" + tecnicoResponsavel +
                ", descricao='" + descricao + '\'' +
                ", codigoTarefa=" + codigoTarefa +
                ", statusTarefa=" + statusTarefa +
                ", prazo=" + prazo +
                '}';
    }
}

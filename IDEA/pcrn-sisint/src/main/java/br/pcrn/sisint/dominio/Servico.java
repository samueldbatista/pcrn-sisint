package br.pcrn.sisint.dominio;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by samue on 09/09/2017.
 */
@Entity
public class Servico {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "text")
    private String titulo;

    private Calendar dataAbertura;

    private Calendar dataFechamento;

    @Column(columnDefinition = "text")
    private String descricao;

    private boolean deletado;

//    @OneToOne(fetch = FetchType.EAGER)

//    private Usuario usuarioResponsavel;
    private StatusServico statusServico;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoServico;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Tarefa> tarefas;

    @OneToOne(fetch = FetchType.EAGER)
    private Setor setorSolicitante;

    private Calendar prazoFinalização;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Calendar getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //    public Usuario getUsuarioResponsavel() {
//        return usuarioResponsavel;
//    }
//
//    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
//        this.usuarioResponsavel = usuarioResponsavel;
//   }

    public StatusServico getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(StatusServico statusServico) {
        this.statusServico = statusServico;
    }

    public Long getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(Long codigoServico) {
        this.codigoServico = codigoServico;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Setor getSetorSolicitante() {
        return setorSolicitante;
    }

    public void setSetorSolicitante(Setor setorSolicitante) {
        this.setorSolicitante = setorSolicitante;
    }

    public Calendar getPrazoFinalização() {
        return prazoFinalização;
    }

    public void setPrazoFinalização(Calendar prazoFinalização) {
        this.prazoFinalização = prazoFinalização;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", dataAbertura=" + dataAbertura +
                ", dataFechamento=" + dataFechamento +
                ", descricao='" + descricao + '\'' +
                ", deletado=" + deletado +
//                ", usuarioResponsavel=" + usuarioResponsavel +
                ", statusServico=" + statusServico +
                ", codigoServico=" + codigoServico +
                ", tarefas=" + tarefas +
                ", setorSolicitante=" + setorSolicitante +
                ", prazoFinalização=" + prazoFinalização +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dataAbertura != null ? dataAbertura.hashCode() : 0);
        result = 31 * result + (dataFechamento != null ? dataFechamento.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (deletado ? 1 : 0);
//        result = 31 * result + (usuarioResponsavel != null ? usuarioResponsavel.hashCode() : 0);
        result = 31 * result + (statusServico != null ? statusServico.hashCode() : 0);
        result = 31 * result + (codigoServico != null ? codigoServico.hashCode() : 0);
        result = 31 * result + (tarefas != null ? tarefas.hashCode() : 0);
        result = 31 * result + (setorSolicitante != null ? setorSolicitante.hashCode() : 0);
        result = 31 * result + (prazoFinalização != null ? prazoFinalização.hashCode() : 0);
        return result;
    }
}

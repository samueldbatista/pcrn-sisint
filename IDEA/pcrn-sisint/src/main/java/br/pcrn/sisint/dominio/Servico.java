package br.pcrn.sisint.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by samue on 09/09/2017.
 */
//@Entity
public class Servico {
//    @Id
//    @GeneratedValue
    private Long id;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private String descricao;
    private boolean deletado;

//    @OneToOne(fetch = FetchType.EAGER)

    private Usuario usuarioResponsavel;
    private StatusServico statusServico;
    private Long codigoServico;

//    @OneToMany(fetch = FetchType.EAGER)
    private List<Tarefa> tarefas;

//    @OneToOne(fetch = FetchType.EAGER)
    private Setor setorSolicitante;
    private LocalDateTime prazoFinalização;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
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

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

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

    public LocalDateTime getPrazoFinalização() {
        return prazoFinalização;
    }

    public void setPrazoFinalização(LocalDateTime prazoFinalização) {
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
                ", usuarioResponsavel=" + usuarioResponsavel +
                ", statusServico=" + statusServico +
                ", codigoServico=" + codigoServico +
                ", tarefas=" + tarefas +
                ", setorSolicitante=" + setorSolicitante +
                ", prazoFinalização=" + prazoFinalização +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servico servico = (Servico) o;

        if (deletado != servico.deletado) return false;
        if (id != null ? !id.equals(servico.id) : servico.id != null) return false;
        if (dataAbertura != null ? !dataAbertura.equals(servico.dataAbertura) : servico.dataAbertura != null)
            return false;
        if (dataFechamento != null ? !dataFechamento.equals(servico.dataFechamento) : servico.dataFechamento != null)
            return false;
        if (descricao != null ? !descricao.equals(servico.descricao) : servico.descricao != null) return false;
        if (usuarioResponsavel != null ? !usuarioResponsavel.equals(servico.usuarioResponsavel) : servico.usuarioResponsavel != null)
            return false;
        if (statusServico != servico.statusServico) return false;
        if (codigoServico != null ? !codigoServico.equals(servico.codigoServico) : servico.codigoServico != null)
            return false;
        if (tarefas != null ? !tarefas.equals(servico.tarefas) : servico.tarefas != null) return false;
        if (setorSolicitante != null ? !setorSolicitante.equals(servico.setorSolicitante) : servico.setorSolicitante != null)
            return false;
        return prazoFinalização != null ? prazoFinalização.equals(servico.prazoFinalização) : servico.prazoFinalização == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dataAbertura != null ? dataAbertura.hashCode() : 0);
        result = 31 * result + (dataFechamento != null ? dataFechamento.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (deletado ? 1 : 0);
        result = 31 * result + (usuarioResponsavel != null ? usuarioResponsavel.hashCode() : 0);
        result = 31 * result + (statusServico != null ? statusServico.hashCode() : 0);
        result = 31 * result + (codigoServico != null ? codigoServico.hashCode() : 0);
        result = 31 * result + (tarefas != null ? tarefas.hashCode() : 0);
        result = 31 * result + (setorSolicitante != null ? setorSolicitante.hashCode() : 0);
        result = 31 * result + (prazoFinalização != null ? prazoFinalização.hashCode() : 0);
        return result;
    }
}

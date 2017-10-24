package br.pcrn.sisint.dominio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by samue on 09/09/2017.
 */
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text")
    private String titulo;

    private LocalDate dataAbertura;

    private LocalDate dataFechamento;

    @Column(columnDefinition = "text")
    private String descricao;

    private boolean deletado;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario tecnico;

    @Enumerated(EnumType.STRING)
    private StatusServico statusServico;

    private Long codigoServico;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Tarefa> tarefas;

    @ManyToOne(fetch = FetchType.EAGER)
    private Setor setor;

    private String prazoFinalização;

    private Prioridade prioridade;

    private boolean pendencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
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

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        this.tecnico = tecnico;
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

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getPrazoFinalização() {
        return prazoFinalização;
    }

    public void setPrazoFinalização(String prazoFinalização) {
        this.prazoFinalização = prazoFinalização;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isPendencia() {
        return pendencia;
    }

    public void setPendencia(boolean pendencia) {
        this.pendencia = pendencia;
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
                ", setor=" + setor +
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
        result = 31 * result + (setor != null ? setor.hashCode() : 0);
        result = 31 * result + (prazoFinalização != null ? prazoFinalização.hashCode() : 0);
        return result;
    }
}

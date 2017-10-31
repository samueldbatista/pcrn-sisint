package br.pcrn.sisint.dominio;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by samue on 09/09/2017.
 */
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario tecnico;

    @ManyToOne(fetch = FetchType.EAGER)
    private Servico servico;

    private String descricao;

    private Long codigoTarefa;

    private StatusTarefa statusTarefa;

    private LocalDate dataFechamento;

    private boolean pendente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
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

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        this.tecnico = tecnico;
    }
}

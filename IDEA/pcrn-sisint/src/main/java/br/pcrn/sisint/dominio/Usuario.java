package br.pcrn.sisint.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by samue on 08/09/2017.
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

//    private LocalDateTime dataCadastro;

//    @Enumerated(EnumType.STRING)
//    private TipoUsuario tipoUsuario;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public LocalDateTime getDataCadastro() {
//        return dataCadastro;
//    }
//
//    public void setDataCadastro(LocalDateTime dataCadastro) {
//        this.dataCadastro = dataCadastro;
//    }

//    public TipoUsuario getTipoUsuario() {
//        return tipoUsuario;
//    }
//
//    public void setTipoUsuario(TipoUsuario tipoUsuario) {
//        this.tipoUsuario = tipoUsuario;
//    }
}

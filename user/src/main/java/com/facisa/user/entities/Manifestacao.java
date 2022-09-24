package com.facisa.user.entities;

import com.facisa.user.entities.enums.ManifestacaoStatus;
import com.facisa.user.entities.enums.ManifestacaoTipo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "Manifestacao_Registro")
public class Manifestacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private String titulo;
    private String descricao;
    private Integer manifestacaoTipo;
    private Integer manifestacaoStatus;


    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Usuario client;


    private Manifestacao() {
    }

    public Manifestacao(Long id,Instant moment, String titulo, String descricao, ManifestacaoTipo manifestacaoTipo,  ManifestacaoStatus manifestacaoStatus , Usuario client) {
        this.id = id;
        this.moment = moment;
        this.titulo = titulo;
        this.descricao = descricao;
        this.client = client;
        setManifestacaoTipo(manifestacaoTipo);
        setManifestacaoStatus(manifestacaoStatus);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getClient() {
        return client;
    }

    public void setClient(Usuario client) {
        this.client = client;
    }

    public ManifestacaoStatus getManifestacaoStatus() {
        return ManifestacaoStatus.valueOf(manifestacaoStatus);
    }

    public void setManifestacaoStatus(ManifestacaoStatus manifestacaoStatus) {
        if (manifestacaoStatus != null) {
            this.manifestacaoStatus = manifestacaoStatus.getCode();
        }
    }

    public ManifestacaoTipo getManifestacaoTipo() {
        return ManifestacaoTipo.valueOf(manifestacaoTipo);
    }

    public void setManifestacaoTipo(ManifestacaoTipo manifestacaoTipo) {
        if (manifestacaoTipo != null) {
            this.manifestacaoTipo = manifestacaoTipo.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manifestacao that = (Manifestacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

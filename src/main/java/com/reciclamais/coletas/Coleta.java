package com.reciclamais.coletas;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "coleta")
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String tipoobjetodescartado;
    private String objetodescartado;
    private String responsavelcoleta;
    private String motivodescarte;
    private LocalDateTime datahora;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoobjetodescartado() {
        return tipoobjetodescartado;
    }

    public void setTipoobjetodescartado(String tipoobjetodescartado) {
        this.tipoobjetodescartado = tipoobjetodescartado;
    }

    public String getObjetodescartado() {
        return objetodescartado;
    }

    public void setObjetodescartado(String objetodescartado) {
        this.objetodescartado = objetodescartado;
    }

    public String getResponsavelcoleta() {
        return responsavelcoleta;
    }

    public void setResponsavelcoleta(String responsavelcoleta) {
        this.responsavelcoleta = responsavelcoleta;
    }

    public String getMotivodescarte() {
        return motivodescarte;
    }

    public void setMotivodescarte(String motivodescarte) {
        this.motivodescarte = motivodescarte;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }
}

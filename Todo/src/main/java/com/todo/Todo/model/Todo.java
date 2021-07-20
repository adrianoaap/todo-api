package com.todo.Todo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String descricao;

    @Column
    private Boolean feito;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataConclucao;

    @PrePersist
    public void antesSalvarBanco(){
        setDataCriacao(LocalDateTime.now());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFeito(Boolean feito) {
        this.feito = feito;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataConclucao(LocalDateTime dataConclucao) {
        this.dataConclucao = dataConclucao;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getFeito() {
        return feito;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataConclucao() {
        return dataConclucao;
    }
}

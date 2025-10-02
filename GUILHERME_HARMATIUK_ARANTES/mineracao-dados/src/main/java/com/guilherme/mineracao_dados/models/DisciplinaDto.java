package com.guilherme.mineracao_dados.models;

public class DisciplinaDto {
    private Integer id;
    private String nome;
    private String professor;

    public Integer getId() { return this.id; }
    public String getNome() { return this.nome; }
    public String getProfessor() { return this.professor; }
    public void setId(Integer id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setProfessor(String professor) { this.professor = professor; }
}

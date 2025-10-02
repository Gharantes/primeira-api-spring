package com.guilherme.mineracao_dados.models.input;

public class CreateDisciplinaDto {
    private String nome;
    private String professor;
    public String getNome() { return this.nome; }
    public String getProfessor() { return this.professor; }
    public void setNome(String nome) { this.nome = nome; }
    public void setProfessor(String professor) { this.professor = professor; }
}

package com.guilherme.mineracao_dados.models;

import java.util.List;

public class TurmaDto {
    private Integer id;
    private String nome;
    private DisciplinaDto disciplina;
    private List<AlunoDto> alunos;

    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public DisciplinaDto getDisciplina() { return disciplina; }
    public List<AlunoDto> getAlunos() { return alunos; }

    public void setId(Integer id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDisciplina(DisciplinaDto disciplina) { this.disciplina = disciplina; }
    public void setAlunos(List<AlunoDto> alunos) { this.alunos = alunos; }
}
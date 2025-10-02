package com.guilherme.mineracao_dados.domain;

import com.guilherme.mineracao_dados.models.TurmaDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="turma")
public class TurmaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id") private int id;

    @Column(name="nome") private String nome;

    @OneToMany(
            mappedBy = "turma",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    ) private List<AlunoEntity> alunos;

    @ManyToOne private DisciplinaEntity disciplina;

    public Integer getId() { return this.id; }
    public String getNome() { return this.nome; }
    public List<AlunoEntity> getAlunos() {
        return Objects.requireNonNullElseGet(this.alunos, ArrayList::new);
    }
    public DisciplinaEntity getDisciplina() { return this.disciplina; }

    public void setNome(String nome) { this.nome = nome; }
    public void setAlunos(List<AlunoEntity> alunos) { this.alunos = alunos; }
    public void setDisciplina(DisciplinaEntity disciplina) { this.disciplina = disciplina; }

    public TurmaDto toDto() {
        TurmaDto turma = new TurmaDto();
        turma.setId(this.getId());
        turma.setNome(this.getNome());
        turma.setDisciplina(this.getDisciplina().toDto());
        turma.setAlunos(this.getAlunos().stream().map(AlunoEntity::toDto).toList());
        return turma;
    }
}
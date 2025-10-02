package com.guilherme.mineracao_dados.domain;

import com.guilherme.mineracao_dados.models.AlunoDto;
import jakarta.persistence.*;

@Entity
@Table(name="aluno")
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id") private int id;

    @Column(name="nome") private String nome;

    @ManyToOne private TurmaEntity turma;

    public Integer getId() { return this.id; }
    public String getNome() { return this.nome; }
    public TurmaEntity getTurma() { return this.turma; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTurma(TurmaEntity turma) { this.turma = turma; }

    public AlunoDto toDto() {
        AlunoDto dto = new AlunoDto();
        dto.setId(this.getId());
        dto.setNome(this.getNome());
        return dto;
    }
}

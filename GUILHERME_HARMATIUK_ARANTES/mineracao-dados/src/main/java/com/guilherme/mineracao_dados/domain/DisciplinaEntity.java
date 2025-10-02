package com.guilherme.mineracao_dados.domain;

import com.guilherme.mineracao_dados.models.DisciplinaDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="disciplina")
public class DisciplinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id") private int id;

    @Column(name="nome") private String nome;

    @Column(name="professor") private String professor;

    @OneToMany(
            mappedBy = "disciplina",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    ) private List<TurmaEntity> turmas;

    public Integer getId() { return this.id; }
    public String getNome() { return this.nome; }
    public String getProfessor() { return this.professor; }
    public List<TurmaEntity> getTurmas() { return this.turmas; }

    public void setNome(String nome) { this.nome = nome; }
    public void setProfessor(String professor) { this.professor = professor; }

    public DisciplinaDto toDto() {
        DisciplinaDto dto = new DisciplinaDto();
        dto.setId(this.getId());
        dto.setNome(this.getNome());
        dto.setProfessor(this.getProfessor());
        return dto;
    }
}

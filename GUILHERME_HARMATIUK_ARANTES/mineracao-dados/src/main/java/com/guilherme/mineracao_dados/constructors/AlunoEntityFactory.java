package com.guilherme.mineracao_dados.constructors;

import com.guilherme.mineracao_dados.domain.AlunoEntity;
import com.guilherme.mineracao_dados.domain.TurmaEntity;
import com.guilherme.mineracao_dados.models.input.CreateAlunoDto;
import com.guilherme.mineracao_dados.repository.AlunoRepository;
import com.guilherme.mineracao_dados.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoEntityFactory {
    @Autowired
    TurmaRepository turmaRepository;
    @Autowired
    AlunoRepository alunoRepository;


    public AlunoEntity createEntity(CreateAlunoDto aluno) {
        if (aluno.getIdTurma() == null) {
            throw new RuntimeException("Um aluno deve possuir turma.");
        }
        TurmaEntity turma = turmaRepository
                .findById(aluno.getIdTurma())
                .orElseThrow(() -> new RuntimeException("Turma não existe"));

        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setNome(aluno.getNome());
        alunoEntity.setTurma(turma);
        return alunoRepository.save(alunoEntity);
    }
}

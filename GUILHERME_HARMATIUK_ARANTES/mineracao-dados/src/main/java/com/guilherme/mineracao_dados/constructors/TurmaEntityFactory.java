package com.guilherme.mineracao_dados.constructors;

import com.guilherme.mineracao_dados.domain.DisciplinaEntity;
import com.guilherme.mineracao_dados.domain.TurmaEntity;
import com.guilherme.mineracao_dados.models.TurmaDto;
import com.guilherme.mineracao_dados.models.input.CreateTurmaDto;
import com.guilherme.mineracao_dados.repository.DisciplinaRepository;
import com.guilherme.mineracao_dados.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaEntityFactory {
    @Autowired
    DisciplinaRepository disciplinaRepository;
    @Autowired
    TurmaRepository turmaRepository;

    public TurmaEntity createEntity(CreateTurmaDto turma) throws RuntimeException {
        if (turma.getIdDisciplina() == null) {
            throw new RuntimeException("Uma turma deve possuir disciplina.");
        }
        DisciplinaEntity disciplina = disciplinaRepository
                .findById(turma.getIdDisciplina())
                .orElseThrow(() -> new RuntimeException("Disciplina não existe"));
        TurmaEntity turmaEntity = new TurmaEntity();
        turmaEntity.setNome(turma.getNome());
        turmaEntity.setDisciplina(disciplina);
        return turmaRepository.save(turmaEntity);
    }
}

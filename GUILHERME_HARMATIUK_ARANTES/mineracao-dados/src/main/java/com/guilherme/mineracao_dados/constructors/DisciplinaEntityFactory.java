package com.guilherme.mineracao_dados.constructors;

import com.guilherme.mineracao_dados.domain.DisciplinaEntity;
import com.guilherme.mineracao_dados.models.input.CreateAlunoDto;
import com.guilherme.mineracao_dados.models.input.CreateDisciplinaDto;
import com.guilherme.mineracao_dados.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaEntityFactory {

    @Autowired
    DisciplinaRepository repository;

    public DisciplinaEntity createEntity(CreateDisciplinaDto disciplinaDto) {
        DisciplinaEntity entity = new DisciplinaEntity();
        entity.setNome(disciplinaDto.getNome());
        entity.setProfessor(disciplinaDto.getProfessor());
        return repository.save(entity);
    }
}

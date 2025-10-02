package com.guilherme.mineracao_dados.rest;

import com.guilherme.mineracao_dados.constructors.AlunoEntityFactory;
import com.guilherme.mineracao_dados.constructors.DisciplinaEntityFactory;
import com.guilherme.mineracao_dados.domain.AlunoEntity;
import com.guilherme.mineracao_dados.domain.DisciplinaEntity;
import com.guilherme.mineracao_dados.models.AlunoDto;
import com.guilherme.mineracao_dados.models.DisciplinaDto;
import com.guilherme.mineracao_dados.models.input.CreateAlunoDto;
import com.guilherme.mineracao_dados.models.input.CreateDisciplinaDto;
import com.guilherme.mineracao_dados.repository.AlunoRepository;
import com.guilherme.mineracao_dados.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private DisciplinaEntityFactory factory;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaDto createDisciplina(@RequestBody CreateDisciplinaDto params) {
        return factory.createEntity(params).toDto();
    }
    @GetMapping("find-all")
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplinaDto> findAllTurmas() {
        return disciplinaRepository.findAll().stream().map(DisciplinaEntity::toDto).toList();
    }
    @DeleteMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDisciplinaById(@RequestParam("id") Integer id) {
        disciplinaRepository.deleteById(id);
    }
}

package com.guilherme.mineracao_dados.rest;

import com.guilherme.mineracao_dados.constructors.AlunoEntityFactory;
import com.guilherme.mineracao_dados.domain.AlunoEntity;
import com.guilherme.mineracao_dados.models.AlunoDto;
import com.guilherme.mineracao_dados.models.input.CreateAlunoDto;
import com.guilherme.mineracao_dados.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private AlunoEntityFactory factory;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.OK)
    public AlunoDto createAluno(@RequestBody CreateAlunoDto params) {
        return factory.createEntity(params).toDto();
    }
    @GetMapping("find-all")
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoDto> findAllAlunos() {
        return alunoRepository.findAll().stream().map(AlunoEntity::toDto).toList();
    }
    @DeleteMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAlunoById(@RequestParam("id") Integer id) {
        alunoRepository.deleteById(id);
    }
}

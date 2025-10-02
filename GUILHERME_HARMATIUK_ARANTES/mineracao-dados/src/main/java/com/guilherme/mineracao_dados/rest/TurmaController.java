package com.guilherme.mineracao_dados.rest;

import com.guilherme.mineracao_dados.constructors.TurmaEntityFactory;
import com.guilherme.mineracao_dados.domain.TurmaEntity;
import com.guilherme.mineracao_dados.models.TurmaDto;
import com.guilherme.mineracao_dados.models.input.CreateTurmaDto;
import com.guilherme.mineracao_dados.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private TurmaEntityFactory factory;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.OK)
    public TurmaDto createTurma(@RequestBody CreateTurmaDto params) {
        return factory.createEntity(params).toDto();
    }
    @GetMapping("find-all")
    @ResponseStatus(HttpStatus.OK)
    public List<TurmaDto> findAllTurmas() {
        return turmaRepository.findAll().stream().map(TurmaEntity::toDto).toList();
    }
    @DeleteMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTurmaById(@RequestParam("id") Integer id) {
        turmaRepository.deleteById(id);
    }
}

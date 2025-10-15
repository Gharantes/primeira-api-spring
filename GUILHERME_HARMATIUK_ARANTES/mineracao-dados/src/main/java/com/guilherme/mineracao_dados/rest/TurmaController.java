package com.guilherme.mineracao_dados.rest;

import com.guilherme.mineracao_dados.constructors.TurmaEntityFactory;
import com.guilherme.mineracao_dados.domain.DisciplinaEntity;
import com.guilherme.mineracao_dados.domain.TurmaEntity;
import com.guilherme.mineracao_dados.models.TurmaDto;
import com.guilherme.mineracao_dados.models.input.CreateTurmaDto;
import com.guilherme.mineracao_dados.repository.DisciplinaRepository;
import com.guilherme.mineracao_dados.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private TurmaEntityFactory factory;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.OK)
    public TurmaDto createTurma(@RequestBody CreateTurmaDto params) {
        return factory.createEntity(params).toDto();
    }
    @PutMapping("update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TurmaDto updateTurma(
            @PathVariable("id") int id,
            @RequestBody CreateTurmaDto params
    ) {
        TurmaEntity turma = turmaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não existe"));
        turma.setNome(params.getNome());

        DisciplinaEntity disciplina = disciplinaRepository
                .findById(params.getIdDisciplina())
                .orElseThrow(() -> new RuntimeException("Disciplina não existe"));
        turma.setDisciplina(disciplina);

        return turmaRepository.save(turma).toDto();
    }

    @GetMapping("find-all")
    @ResponseStatus(HttpStatus.OK)
    public List<TurmaDto> findAllTurmas() {
        return turmaRepository.findAll().stream().map(TurmaEntity::toDto).toList();
    }
    @GetMapping("find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TurmaDto findTurmaById(@PathVariable("id") int id) {
        TurmaEntity turma = turmaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não existe"));
        return turma.toDto();
    }
    @DeleteMapping("delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTurmaById(@RequestParam("id") Integer id) {
        turmaRepository.deleteById(id);
    }
}

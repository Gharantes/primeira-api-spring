package com.guilherme.mineracao_dados.repository;

import com.guilherme.mineracao_dados.domain.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Integer> {
}

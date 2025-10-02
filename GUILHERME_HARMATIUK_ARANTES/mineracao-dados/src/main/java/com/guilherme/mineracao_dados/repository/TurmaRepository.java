package com.guilherme.mineracao_dados.repository;

import com.guilherme.mineracao_dados.domain.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntity, Integer> {
}
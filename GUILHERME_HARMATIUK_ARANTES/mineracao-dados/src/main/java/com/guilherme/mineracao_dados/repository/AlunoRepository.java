package com.guilherme.mineracao_dados.repository;

import com.guilherme.mineracao_dados.domain.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {
}

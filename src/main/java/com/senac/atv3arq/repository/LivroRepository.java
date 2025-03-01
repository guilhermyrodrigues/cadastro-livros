package com.senac.atv3arq.repository;

import com.senac.atv3arq.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Integer> {
}

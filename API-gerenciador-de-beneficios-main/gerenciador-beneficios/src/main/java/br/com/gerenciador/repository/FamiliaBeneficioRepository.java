package br.com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciador.model.FamiliaBeneficioModelo;

@Repository
public interface FamiliaBeneficioRepository extends JpaRepository<FamiliaBeneficioModelo, Long> {}

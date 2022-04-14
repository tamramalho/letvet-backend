package com.tamara.letvet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tamara.letvet.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);
}

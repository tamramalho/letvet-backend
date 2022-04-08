package com.tamara.letvet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tamara.letvet.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
}

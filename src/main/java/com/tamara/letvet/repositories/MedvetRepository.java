package com.tamara.letvet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tamara.letvet.domain.Medvet;

public interface MedvetRepository extends JpaRepository<Medvet, Integer>{
	
}

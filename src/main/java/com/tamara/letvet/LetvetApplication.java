package com.tamara.letvet;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tamara.letvet.domain.Consulta;
import com.tamara.letvet.domain.Medvet;
import com.tamara.letvet.domain.Pacientepet;
import com.tamara.letvet.domain.enums.Perfil;
import com.tamara.letvet.domain.enums.Prioridade;
import com.tamara.letvet.domain.enums.Status;
import com.tamara.letvet.repositories.ConsultaRepository;
import com.tamara.letvet.repositories.MedvetRepository;
import com.tamara.letvet.repositories.PacientepetRepository;

@SpringBootApplication
public class LetvetApplication implements CommandLineRunner{
	
	@Autowired
	private MedvetRepository medvetRepository;
	
	@Autowired
	private PacientepetRepository pacientepetRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(LetvetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Medvet mv1 = new Medvet(null, "Letícia Ramalho", "13262419826", "leticia@mail.com", "123");
		mv1.addPerfil(Perfil.ADMIN);
		
		Pacientepet pp1 = new Pacientepet(null, "Ravena", "89831617525", "arnaldo@mail.com", "456");
		
		Consulta c1 = new Consulta(null, Prioridade.POUCO_URGENTE, Status.ANDAMENTO, "Consulta Rotineira", "Primeira consulta", mv1, pp1);
		
		medvetRepository.saveAll(Arrays.asList(mv1));
		pacientepetRepository.saveAll(Arrays.asList(pp1));
		consultaRepository.saveAll(Arrays.asList(c1));
	}

}

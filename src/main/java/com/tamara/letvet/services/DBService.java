package com.tamara.letvet.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamara.letvet.domain.Consulta;
import com.tamara.letvet.domain.Medvet;
import com.tamara.letvet.domain.Pacientepet;
import com.tamara.letvet.domain.enums.Perfil;
import com.tamara.letvet.domain.enums.Prioridade;
import com.tamara.letvet.domain.enums.Status;
import com.tamara.letvet.repositories.ConsultaRepository;
import com.tamara.letvet.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	public void instanciaDB() {
		Medvet mv1 = new Medvet(null, "Letícia Ramalho", "132.624.198-26", "leticia@mail.com", "123");
		mv1.addPerfil(Perfil.ADMIN);
		Medvet mv2 = new Medvet(null, "Richard Andrade", "116.814.545-72", "richard@mail.com", "456");
		Medvet mv3 = new Medvet(null, "Humberto Fialho", "155.111.486-01", "humberto@mail.com", "789");
		Medvet mv4 = new Medvet(null, "Alice Rodrigues", "396.848.654-49", "alice@mail.com", "147");
		Medvet mv5 = new Medvet(null, "Diogo Fernandes", "743.782.437-09", "diogo@mail.com", "258");
		
		Pacientepet pp1 = new Pacientepet(null, "Ravena", "898.316.175-25", "arnaldo@mail.com", "369");
		Pacientepet pp2 = new Pacientepet(null, "Spyke", "643.897.745-49", "maria@mail.com", "159");
		Pacientepet pp3 = new Pacientepet(null, "Floquinho", "208.440.624-21", "roberto@mail.com", "753");
		Pacientepet pp4 = new Pacientepet(null, "Apolo", "126.658.426-96", "joana@mail.com", "483");
		Pacientepet pp5 = new Pacientepet(null, "Maya", "295.480.673-74", "pedro@mail.com", "264");
		
		Consulta c1 = new Consulta(null, Prioridade.POUCO_URGENTE, Status.ANDAMENTO, "Consulta Rotineira", "Teste Consulta 1", mv1, pp1);
		Consulta c2 = new Consulta(null, Prioridade.MUITO_URGENTE, Status.FINALIZADA, "Pronto socorro", "Teste Consulta 2", mv2, pp2);
		Consulta c3 = new Consulta(null, Prioridade.URGENTE, Status.MARCADA, "Consulta de urgência", "Teste Consulta 3", mv3, pp3);
		Consulta c4 = new Consulta(null, Prioridade.POUCO_URGENTE, Status.FINALIZADA, "Acompanhamento pós-cirúrgico", "Teste Consulta 4", mv4, pp4);
		Consulta c5 = new Consulta(null, Prioridade.URGENTE, Status.ANDAMENTO, "Consulta de urgência", "Teste Consulta 5", mv5, pp5);
		
		//medvetRepository.saveAll(Arrays.asList(mv1, mv2, mv3, mv4, mv5));
		//pacientepetRepository.saveAll(Arrays.asList(pp1, pp2, pp3, pp4, pp5));
		pessoaRepository.saveAll(Arrays.asList(mv1, mv2, mv3, mv4, mv5, pp1, pp2, pp3, pp4, pp5));
		consultaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
	}
}

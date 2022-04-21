package com.tamara.letvet.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tamara.letvet.domain.Consulta;
import com.tamara.letvet.domain.dtos.ConsultaDTO;
import com.tamara.letvet.services.ConsultaService;

@RestController
@RequestMapping(value = "/consulta")
public class ConsultaResource {
	
	@Autowired
	private ConsultaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ConsultaDTO> findById(@PathVariable Integer id){
		Consulta obj = service.findById(id);
		return ResponseEntity.ok().body(new ConsultaDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ConsultaDTO>> findAll(){
		List<Consulta> list = service.findAll();
		List<ConsultaDTO> listDTO = list.stream().map(obj -> new ConsultaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}

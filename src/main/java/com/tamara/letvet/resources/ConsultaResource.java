package com.tamara.letvet.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<ConsultaDTO> create(@Valid @RequestBody ConsultaDTO objDTO){
		Consulta obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

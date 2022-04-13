package com.tamara.letvet.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tamara.letvet.domain.Medvet;
import com.tamara.letvet.domain.dtos.MedvetDTO;
import com.tamara.letvet.services.MedvetService;

@RestController
@RequestMapping(value = "/medvet")
public class MedvetResource {
	
	@Autowired
	private MedvetService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MedvetDTO> findById(@PathVariable Integer id){
		Medvet obj = this.service.findById(id);
		return ResponseEntity.ok().body(new MedvetDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<MedvetDTO>> findAll(){
		List<Medvet> list = service.findAll();
		List<MedvetDTO> listDTO = list.stream().map(obj -> new MedvetDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}

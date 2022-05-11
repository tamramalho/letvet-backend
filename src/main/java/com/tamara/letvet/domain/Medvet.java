package com.tamara.letvet.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tamara.letvet.domain.dtos.MedvetDTO;
import com.tamara.letvet.domain.enums.Perfil;

@Entity
public class Medvet extends Pessoa{
	public static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "medvet")
	private List<Consulta> consultas = new ArrayList<>();

	public Medvet() {
		super();
		addPerfil(Perfil.PACIENTEPET);
		addPerfil(Perfil.MEDVET);
	}

	public Medvet(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.PACIENTEPET);
		addPerfil(Perfil.MEDVET);
	}
	
	public Medvet(MedvetDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	
}

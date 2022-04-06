package com.tamara.letvet.domain;

import java.util.ArrayList;
import java.util.List;

public class Medvet extends Pessoa{
	
	private List<Consulta> consultas = new ArrayList<>();

	public Medvet() {
		super();
	}

	public Medvet(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	
}

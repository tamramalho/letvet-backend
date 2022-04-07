package com.tamara.letvet.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.tamara.letvet.domain.enums.Perfil;

@Entity
public class Pacientepet extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "pacientepet")
	private List<Consulta> consultas = new ArrayList<>();

	public Pacientepet() {
		super();
		addPerfil(Perfil.PACIENTEPET);
	}

	public Pacientepet(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.PACIENTEPET);
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	
}

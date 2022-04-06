package com.tamara.letvet.domain;

import java.time.LocalDate;

import com.tamara.letvet.domain.enums.Prioridade;
import com.tamara.letvet.domain.enums.Status;

public class Consulta {
	
	private Integer id;
	private LocalDate dataConsulta = LocalDate.now();
	private LocalDate dataAtendimento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	
	private Medvet medvet;
	private Pacientepet pacientepet;
	
	public Consulta() {
		super();
	}

	public Consulta(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Medvet medvet,
			Pacientepet pacientepet) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.medvet = medvet;
		this.pacientepet = pacientepet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public LocalDate getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(LocalDate dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Medvet getMedvet() {
		return medvet;
	}

	public void setMedvet(Medvet medvet) {
		this.medvet = medvet;
	}

	public Pacientepet getPacientepet() {
		return pacientepet;
	}

	public void setPacientepet(Pacientepet pacientepet) {
		this.pacientepet = pacientepet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

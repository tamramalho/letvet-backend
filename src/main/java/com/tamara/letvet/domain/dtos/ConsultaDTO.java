package com.tamara.letvet.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tamara.letvet.domain.Consulta;

public class ConsultaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataConsulta = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAtendimento;
	
	@NotNull(message = "O campo PRIORIDADE é obrigatório!")
	private Integer prioridade;
	
	@NotNull(message = "O campo STATUS é obrigatório!")
	private Integer status;
	
	@NotNull(message = "O campo TÍTULO é obrigatório!")
	private String titulo;
	
	@NotNull(message = "O campo OBSERVAÇÕES é obrigatório!")
	private String observacoes;
	
	@NotNull(message = "O campo MED. VET. é obrigatório!")
	private Integer medvet;
	
	@NotNull(message = "O campo PACIENTE PET é obrigatório!")
	private Integer pacientepet;
	
	
	private String nomeMedvet;
	private String nomePacientepet;
	
	public ConsultaDTO() {
		super();
	}

	public ConsultaDTO(Consulta obj) {
		super();
		this.id = obj.getId();
		this.dataConsulta = obj.getDataConsulta();
		this.dataAtendimento = obj.getDataAtendimento();
		this.prioridade = obj.getPrioridade().getCodigo();
		this.status = obj.getStatus().getCodigo();
		this.titulo = obj.getTitulo();
		this.observacoes = obj.getObservacoes();
		this.medvet = obj.getMedvet().getId();
		this.pacientepet = obj.getPacientepet().getId();
		this.nomeMedvet = obj.getMedvet().getNome();
		this.nomePacientepet = obj.getPacientepet().getNome();
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

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Integer getMedvet() {
		return medvet;
	}

	public void setMedvet(Integer medvet) {
		this.medvet = medvet;
	}

	public Integer getPacientepet() {
		return pacientepet;
	}

	public void setPacientepet(Integer pacientepet) {
		this.pacientepet = pacientepet;
	}

	public String getNomeMedvet() {
		return nomeMedvet;
	}

	public void setNomeMedvet(String nomeMedvet) {
		this.nomeMedvet = nomeMedvet;
	}

	public String getNomePacientepet() {
		return nomePacientepet;
	}

	public void setNomePacientepet(String nomePacientepet) {
		this.nomePacientepet = nomePacientepet;
	}
}

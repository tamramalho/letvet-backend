package com.tamara.letvet.domain.enums;

public enum Status {
	MARCADA(0, "MARCADA"), ANDAMENTO(1, "ANDAMENTO"), FINALIZADA(2, "FINALIZADA");
	
	private Integer codigo;
	private String descricao;
	
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status Inválido!");
	}
}

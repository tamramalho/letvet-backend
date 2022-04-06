package com.tamara.letvet.domain.enums;

public enum Prioridade {
	POUCO_URGENTE(0, "POUCO_URGENTE"), URGENTE(1, "URGENTE"), MUITO_URGENTE(2, "MUITO_URGENTE");
	
	private Integer codigo;
	private String descricao;
	
	private Prioridade(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Prioridade toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for(Prioridade x : Prioridade.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Prioridade Inválida!");
	}
}

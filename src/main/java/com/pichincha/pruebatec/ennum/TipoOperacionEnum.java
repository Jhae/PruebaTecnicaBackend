package com.pichincha.pruebatec.ennum;

import lombok.Getter;

@Getter
public enum TipoOperacionEnum {
	DEPOSITO(1L)
	,RETIRO(2L)
	;
	
	private final Long val;
	
	TipoOperacionEnum(Long valor) {
		this.val = valor;
	}
}

package com.pichincha.pruebatec.request;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class RealizarMovimientoReq {
	
	private String num_cuenta;
	private BigDecimal monto;
	private Long tipo_movimiento;
	
}

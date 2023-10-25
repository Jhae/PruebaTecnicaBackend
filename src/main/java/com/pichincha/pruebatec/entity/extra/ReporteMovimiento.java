package com.pichincha.pruebatec.entity.extra;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class ReporteMovimiento {
	private Date fecha;
	private String nombreCliente;
	private String numeroCuenta;
	private String tipoCuenta;
	private String tipoMovimiento;
	private BigDecimal saldoInicial;
	private BigDecimal montoMovimiento;
	private BigDecimal saldoFinal;
	private Boolean estadoMovimiento;
}

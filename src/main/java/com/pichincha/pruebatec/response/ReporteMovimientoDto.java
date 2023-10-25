package com.pichincha.pruebatec.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor @Builder
@Data
public class ReporteMovimientoDto {
	private String fecha;
	private String nombreCliente;
	private String numeroCuenta;
	private String tipoCuenta;
	private String tipoMovimiento;
	private String saldoInicial;
	private String montoMovimiento;
	private String saldoFinal;
	private Boolean estadoMovimiento;
}

package com.pichincha.pruebatec.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pichincha.pruebatec.entity.extra.ReporteMovimiento;

public class ReporteMovimientosMapper implements RowMapper<ReporteMovimiento>{

	@Override
	public ReporteMovimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReporteMovimiento reporteMov = ReporteMovimiento.builder()
			.fecha(rs.getDate("fecha"))
			.nombreCliente(rs.getString("nombre_cliente"))
			.numeroCuenta(rs.getString("numero_cuenta"))
			.tipoCuenta(rs.getString("tipo_cuenta"))
			.tipoMovimiento(rs.getString("tipo_movimiento"))
			.saldoInicial(rs.getBigDecimal("saldo_inicial"))
			.montoMovimiento(rs.getBigDecimal("monto_movimiento"))
			.saldoFinal(rs.getBigDecimal("saldo_final"))
			.estadoMovimiento(rs.getBoolean("estado_movimiento"))
			.build();
		return reporteMov;
	}

}

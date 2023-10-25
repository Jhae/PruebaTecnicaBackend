package com.pichincha.pruebatec.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pichincha.pruebatec.entity.extra.ReporteMovimiento;
import com.pichincha.pruebatec.repository.mapper.ReporteMovimientosMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomMovimientoRepository {
	private final JdbcTemplate jdbcTemplate;
	
	String reporteMovs = "select mv.fecha as fecha, cli.nombres as nombre_cliente, "
			+ "cta.numero as numero_cuenta, "
			+ "tp_cta.nombre as tipo_cuenta, "
			+ "tp_mv.nombre as tipo_movimiento, "
			+ "mv.saldo_inicial as saldo_inicial, "
			+ "mv.valor as monto_movimiento, "
			+ "mv.saldo_final as saldo_final, "
			+ "mv.estado as estado_movimiento "
			+ "from movimiento mv "
			+ "inner join tipo_movimiento tp_mv on tp_mv.id = mv.id_tipo_movimiento "
			+ "inner join cuenta cta on cta.id = mv.id_cuenta "
			+ "inner join tipo_cuenta tp_cta on tp_cta.id = cta.id_tipo_cuenta "
			+ "inner join cliente cli on cli.id = cta.id_cliente "
			+ "where fecha between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') + INTERVAL '1' DAY "
			+ "order by cli.nombres, mv.fecha desc ";
	
	public List<ReporteMovimiento> reporteMovimientos(String fecha_ini, String fecha_fin){

		return jdbcTemplate.query(reporteMovs, new ReporteMovimientosMapper(), fecha_ini, fecha_fin);
	}
	
	
	
}

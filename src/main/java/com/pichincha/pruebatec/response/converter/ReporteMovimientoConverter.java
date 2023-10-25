package com.pichincha.pruebatec.response.converter;

import org.springframework.core.convert.converter.Converter;

import com.pichincha.pruebatec.entity.extra.ReporteMovimiento;
import com.pichincha.pruebatec.response.ReporteMovimientoDto;
import com.pichincha.pruebatec.util.FechaUtil;

public class ReporteMovimientoConverter {
	
	public static class ToReporteMovimientoDto implements Converter<ReporteMovimiento, ReporteMovimientoDto>{

		@Override
		public ReporteMovimientoDto convert(ReporteMovimiento source) {
			return ReporteMovimientoDto.builder()
					.fecha(FechaUtil.formatddMMyyyyHHmmss(source.getFecha()))
					.nombreCliente(source.getNombreCliente())
					.numeroCuenta(source.getNumeroCuenta())
					.tipoCuenta(source.getTipoCuenta())
					.tipoMovimiento(source.getTipoMovimiento())
					.saldoInicial(source.getSaldoInicial().toString())
					.montoMovimiento(source.getMontoMovimiento().toString())
					.saldoFinal(source.getSaldoFinal().toString())
					.estadoMovimiento(source.getEstadoMovimiento())
					.build();
					
		}
		
	}

}

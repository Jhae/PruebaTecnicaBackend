package com.pichincha.pruebatec.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pichincha.pruebatec.ennum.TipoOperacionEnum;
import com.pichincha.pruebatec.entity.Cuenta;
import com.pichincha.pruebatec.entity.Movimiento;
import com.pichincha.pruebatec.entity.TipoMovimiento;
import com.pichincha.pruebatec.entity.extra.ReporteMovimiento;
import com.pichincha.pruebatec.exception.BadRequestException;
import com.pichincha.pruebatec.repository.CuentaRepository;
import com.pichincha.pruebatec.repository.CustomMovimientoRepository;
import com.pichincha.pruebatec.repository.MovimientoRespository;
import com.pichincha.pruebatec.request.RealizarMovimientoReq;
import com.pichincha.pruebatec.response.ReporteMovimientoDto;
import com.pichincha.pruebatec.service.MovimientoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService{
	
	private final MovimientoRespository movimientoRespository;
	private final CustomMovimientoRepository customMovimientoRepository;
	private final CuentaRepository cuentaRepository;
	private final ConversionService converter;
	
	@Override
	public ResponseEntity<?> realizarMovimiento(RealizarMovimientoReq request) throws BadRequestException {
		
		// Consulta de existencia de cuenta
		Optional<Cuenta> cuentaOperacionOpt = cuentaRepository.findByNumero(request.getNum_cuenta());
		
		if (!cuentaOperacionOpt.isPresent()){
			throw new BadRequestException("Cuenta de operacion no encontrada.");
		}
		
		Cuenta cuentaOperacion = cuentaOperacionOpt.get();
		
		// Validacion de saldo disponible
		if (TipoOperacionEnum.RETIRO.getVal().equals(request.getTipo_movimiento())
			&& request.getMonto().compareTo(cuentaOperacion.getSaldoInicial()) == 1) {
			
			throw new BadRequestException("Saldo no disponible.");
		}
		
		// Realizacion de operacion
		BigDecimal saldoInicial = cuentaOperacion.getSaldoInicial();
		BigDecimal saldoFinal = cuentaOperacion.getSaldoInicial();
		
		if(TipoOperacionEnum.RETIRO.getVal().equals(request.getTipo_movimiento())){
			saldoFinal = cuentaOperacion.getSaldoInicial().subtract(request.getMonto());
		}
		else if(TipoOperacionEnum.DEPOSITO.getVal().equals(request.getTipo_movimiento())){
			saldoFinal = cuentaOperacion.getSaldoInicial().add(request.getMonto());
		}
		
		// Persistencia de operacion
		cuentaOperacion.setSaldoInicial(saldoFinal);
		cuentaRepository.save(cuentaOperacion);
		
		TipoMovimiento tipoMovimiento  = TipoMovimiento.builder().id(request.getTipo_movimiento()).build();
		Movimiento movimiento = Movimiento.builder()
			.fecha(new Date())
			.saldoInicial(saldoInicial)
			.valor(request.getMonto())
			.saldoFinal(saldoFinal)
			.estado(true)
			.tipoMovimiento(tipoMovimiento)
			.cuenta(cuentaOperacion)
			.build();
		
		movimientoRespository.save(movimiento);
		
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<ReporteMovimientoDto>> reporteMovimientos(String fecha_ini, String fecha_fin) {
		List<ReporteMovimientoDto> body = new ArrayList<>();
		
		List<ReporteMovimiento> reporteMovs = customMovimientoRepository.reporteMovimientos(fecha_ini, fecha_fin);
		
		body = reporteMovs.stream()
				.map( reporte -> converter.convert(reporte, ReporteMovimientoDto.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok(body);
	}

}

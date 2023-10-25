package com.pichincha.pruebatec.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "movimiento")
public class Movimiento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fecha;
	private BigDecimal saldoInicial;
	private BigDecimal valor;
	private BigDecimal saldoFinal;
	private Boolean estado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_movimiento", referencedColumnName = "id")
	private TipoMovimiento tipoMovimiento;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "id_cuenta", referencedColumnName = "id")
	private Cuenta cuenta;
	
	
}

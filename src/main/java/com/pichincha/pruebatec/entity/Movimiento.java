package com.pichincha.pruebatec.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "movimiento")
public class Movimiento {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fecha;
	private String valor;
	private String saldo;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_movimiento", referencedColumnName = "id")
	private TipoMovimiento tipoMovimiento;
	
	@ManyToOne
	@JoinColumn(name = "id_cuenta", referencedColumnName = "id")
	private Cuenta cuenta;
	
	
}

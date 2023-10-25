package com.pichincha.pruebatec.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "cuenta")
public class Cuenta {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private BigDecimal saldoInicial;
	private Boolean estado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_cuenta",referencedColumnName = "id")
	private TipoCuenta tipoCuenta;
	
	@OneToMany(mappedBy = "cuenta")
	private List<Movimiento> movimientos;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente cliente;
}

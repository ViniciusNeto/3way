package com.api.garagem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 120)
	private String marca;

	@Column(nullable = false, length = 140)
	private String modelo;

	@Column(length = 255)
	private String descricao;

	@Column(length = 120)
	private String cor;

	@Column(nullable = false, unique = true, length = 10)
	private String placa;

	@Column(name = "ano_modelo", nullable = false, length = 4)
	private Integer anoModelo;
}

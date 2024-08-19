package com.api.garagem.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VeiculoDto {

	private long id;

	@NotNull(message = "A marca deve ser informada.")
	private String marca;

	@NotNull(message = "O modelo deve ser informada.")
	private String modelo;

	@NotNull(message = "A descricao deve ser informada.")
	private String descricao;

	@NotNull(message = "A cor deve ser informada.")
	private String cor;

	@NotNull(message = "A placa deve ser informada.")
	private String placa;

	@NotNull(message = "O ano deve ser informada.")
	private Integer anoModelo;

}

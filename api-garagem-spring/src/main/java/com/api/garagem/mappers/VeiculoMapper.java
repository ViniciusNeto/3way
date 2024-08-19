package com.api.garagem.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.api.garagem.dtos.VeiculoDto;
import com.api.garagem.entities.Veiculo;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

	Veiculo toVeiculo(VeiculoDto veiculoDto);

	VeiculoDto toVeiculoDto(Veiculo veiculo);

	List<VeiculoDto> toVeiculoDtos(List<Veiculo> veiculos);

	void updateVeiculo(@MappingTarget Veiculo target, Veiculo source);
}

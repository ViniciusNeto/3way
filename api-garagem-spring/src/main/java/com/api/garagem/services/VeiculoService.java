package com.api.garagem.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.garagem.dtos.VeiculoDto;
import com.api.garagem.entities.Veiculo;
import com.api.garagem.exceptions.AppException;
import com.api.garagem.mappers.VeiculoMapper;
import com.api.garagem.repositories.VeiculoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VeiculoService {

	private final VeiculoRepository veiculoRepository;
	private final VeiculoMapper veiculoMapper;

	public List<VeiculoDto> allVeiculos() {
		return veiculoMapper.toVeiculoDtos(veiculoRepository.findAll());
	}

	public VeiculoDto createVeiculo(VeiculoDto veiculoDto) {
		Veiculo veiculo = veiculoMapper.toVeiculo(veiculoDto);

		Veiculo savedVeiculo = veiculoRepository.save(veiculo);

		return veiculoMapper.toVeiculoDto(savedVeiculo);
	}

	public VeiculoDto updateVeiculo(Long id, VeiculoDto veiculoDto) {
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new AppException("Veiculo nao encontrado!", HttpStatus.NOT_FOUND));

		veiculoMapper.updateVeiculo(veiculo, veiculoMapper.toVeiculo(veiculoDto));

		Veiculo savedVeiculo = veiculoRepository.save(veiculo);

		return veiculoMapper.toVeiculoDto(savedVeiculo);
	}

	public VeiculoDto patchVeiculo(Long id, VeiculoDto veiculoDto) {
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new AppException("Veiculo nao encontrado!", HttpStatus.NOT_FOUND));

		if (veiculoDto.getMarca() != null) {
			veiculo.setMarca(veiculoDto.getMarca());
		}
		if (veiculoDto.getModelo() != null) {
			veiculo.setModelo(veiculoDto.getModelo());
		}
		if (veiculoDto.getCor() != null) {
			veiculo.setCor(veiculoDto.getCor());
		}
		if (veiculoDto.getPlaca() != null) {
			veiculo.setPlaca(veiculoDto.getPlaca());
		}

		Veiculo savedVeiculo = veiculoRepository.save(veiculo);

		return veiculoMapper.toVeiculoDto(savedVeiculo);
	}
	
	public VeiculoDto getVeiculo(Long id) {
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new AppException("Veiculo nao encontrado!", HttpStatus.NOT_FOUND));

		return veiculoMapper.toVeiculoDto(veiculo);
	}
	
	public VeiculoDto deleteVeiculo(Long id) {
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new AppException("Veiculo nao encontrado!", HttpStatus.NOT_FOUND));
		
		VeiculoDto veiculoDto = veiculoMapper.toVeiculoDto(veiculo);
		
		veiculoRepository.deleteById(id);

		return veiculoDto;
	}

}


























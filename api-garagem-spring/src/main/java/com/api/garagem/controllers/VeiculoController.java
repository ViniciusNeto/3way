package com.api.garagem.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.garagem.dtos.VeiculoDto;
import com.api.garagem.services.VeiculoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api-garagem")
@RequiredArgsConstructor
public class VeiculoController {

	private final VeiculoService veiculoService;

	@GetMapping("/veiculos")
	public ResponseEntity<List<VeiculoDto>> allVeiculos() {
		return ResponseEntity.ok(veiculoService.allVeiculos());
	}

	@PostMapping("/veiculos")
	public ResponseEntity<VeiculoDto> createVeiculos(@Valid @RequestBody VeiculoDto veiculoDto) {
		VeiculoDto createVeiculo = veiculoService.createVeiculo(veiculoDto);
		return ResponseEntity.created(URI.create("/veiculos/" + veiculoDto.getId())).body(createVeiculo);
	}

	@GetMapping("/veiculos/{id}")
	public ResponseEntity<VeiculoDto> getVeiculo(@PathVariable Long id) {
		return ResponseEntity.ok(veiculoService.getVeiculo(id));
	}

	@PutMapping("/veiculos/{id}")
	public ResponseEntity<VeiculoDto> updateVeiculo(@PathVariable Long id, @Valid @RequestBody VeiculoDto veiculoDto) {
		return ResponseEntity.ok(veiculoService.updateVeiculo(id, veiculoDto));
	}

	@PatchMapping("/veiculos/{id}")
	public ResponseEntity<VeiculoDto> patchVeiculo(@PathVariable Long id, @Valid @RequestBody VeiculoDto veiculoDto) {
		return ResponseEntity.ok(veiculoService.patchVeiculo(id, veiculoDto));
	}

	@DeleteMapping("/veiculos/{id}")
	public ResponseEntity<VeiculoDto> deleteVeiculo(@PathVariable Long id) {
		return ResponseEntity.ok(veiculoService.deleteVeiculo(id));
	}

}

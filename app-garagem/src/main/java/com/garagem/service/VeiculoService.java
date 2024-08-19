package com.garagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garagem.entity.Veiculo;
import com.garagem.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	public void saveOrUpdate(Veiculo veiculo) {
		repository.save(veiculo);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<Veiculo> findAll() {
		return repository.findAll();
	}

	public Optional<Veiculo> findById(long id) {
		return repository.findById(id);
	}
}

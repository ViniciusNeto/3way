package com.garagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.garagem.entity.Veiculo;
import com.garagem.service.VeiculoService;

@Controller
public class VeiculoController {

	@Autowired
	VeiculoService service;

	@GetMapping("/novo")
	public String novo(Veiculo veiculo) {
		return "frm-veiculo";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("lstVeiculos", service.findAll());
		return "lst-veiculos";
	}

	@PostMapping("/salvar")
	public String salvar(Veiculo veiculo, RedirectAttributes attr) {
		if (veiculo.getId() == null) {
			attr.addFlashAttribute("msg", "Veiculo inserido com sucesso");
		} else {
			attr.addFlashAttribute("msg", "Veiculo alterado com sucesso");
		}
		service.saveOrUpdate(veiculo);
		return "redirect:/novo";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Veiculo veiculo, ModelMap model) {
		model.addAttribute("veiculo", veiculo);
		return "frm-veiculo";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.delete(id);
		model.addAttribute("msg", "Veiculo excluido com sucesso");
		return listar(model);
	}
}

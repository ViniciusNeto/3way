package com.garagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")//Mapeamento da url da aplicacao
	public String home() {
		return "index";//Requisicao da pagina home. Arquivo da pagina sem extencao .html
	}
}

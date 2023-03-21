package com.cibertec.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	//mapeamos el index, creamos un metodo publico que devuelve una cadena
	//colocamos notacion Mapping para que redirecciones cuando coloque http://localhost:8080/administrador
	//en el navegador
	@GetMapping("")
	public String home() {
		
		return "administrador/index";
	}
}

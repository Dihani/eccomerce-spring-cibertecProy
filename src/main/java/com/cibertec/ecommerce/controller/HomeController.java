package com.cibertec.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	//declaramos variable tipo ProductoService, para traer todos los prod.@Autowired(para inyectar de contenedor de framework de la clase productoServce(
	@Autowired
	private ProductoService productoService;
	//metodo para probar el index
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("productos", productoService.findAll());
		return"usuario/index";
	}
}

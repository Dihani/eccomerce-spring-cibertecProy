package com.cibertec.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.ecommerce.model.Producto;
import com.cibertec.ecommerce.service.ProductoService;



@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	//una varible tipo ProductoService (para acceder a productos)
	@Autowired
	private ProductoService productoService;

	//mapeamos el index, creamos un metodo publico que devuelve una cadena
	//colocamos notacion Mapping para que redirecciones cuando coloque http://localhost:8080/administrador
	//en el navegador
	@GetMapping("")
	public String home(Model model) {
		
		List<Producto> productos=productoService.findAll();
		model.addAttribute("productos", productos);
		
		return "administrador/index";
	}
}

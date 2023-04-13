package com.cibertec.ecommerce.controller;

import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.ecommerce.model.Producto;
import com.cibertec.ecommerce.model.Usuario;
import com.cibertec.ecommerce.service.ProductoService;



//anotamos que será un controlador, y con @RequestMapping("/productos") indicamos que mapeará la ruta productos
@Controller
@RequestMapping("/productos")
public class ProductoController {
	//declaramos una variable tipo Logger, para que realice un log en consola de lo que se ejecute en el programa, 
	//es similar a usar systemOutPrint
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);	
	//creamos una variable tipo ProductoService
	@Autowired
	private ProductoService productoService;
	
	
	//redireccionamos a la vista show.html con el siguiente metodo, usamos Model para llevar del backend a la vista
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "/productos/show";
	}
	//metodo que redireccione a la vista de crear productos, que esta dentro de el directorio producto y que se llama create.html
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	//metodo para que procese la peticion guardar producto en la vista Crear producto
	@PostMapping("/save")
	public String save(Producto producto) {
		//hacemos el test con LOGGER, y llamamos al metodo tostring en la clase Producto para poder imprimir en consola
		LOGGER.info("Este es el objeto producto{}", producto);
		
		//para guardar en la bd los productos
		Usuario u = new Usuario(1, "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoService.save(producto);
		
		return "redirect:/productos";
	}
	//metodo para editar, usamos la notacion de spring @PathVariable, mapea la variable que viene en la url (@GetMapping("/edit/{id}"))
	//y la pasa a la variabe que se define en la creación del metodo
	@GetMapping("/edit/{idProducto}")
	public String edit(@PathVariable Integer idProducto, Model model) {
		//creamos un objeto de tipo producto
		Producto producto = new Producto();
		//definimos una variable de tipo Optional, porque esto nos devuelve cuando hacemos la busqueda de un objeto de tipo Producto
		Optional<Producto> optionalProducto=productoService.get(idProducto);
		producto= optionalProducto.get();
		
		LOGGER.info("Producto buscado:{}", producto);
		model.addAttribute("producto", producto);
		
		
		return "productos/edit";
	}
	
	//metodo para actualizar los datos editados, repondera a una peticion de tipo post
	@PostMapping("/update")
	public String update(Producto producto) {
		productoService.update(producto);
		
		return "redirect:/productos";
	}
	
	//metodo para eliminar, repondera a una peticion de tipo get
	@GetMapping("/delete/{idProducto}")
		public String delete(@PathVariable Integer idProducto) {
		productoService.delete(idProducto);
		return "redirect:/productos";
	}
	
	
}

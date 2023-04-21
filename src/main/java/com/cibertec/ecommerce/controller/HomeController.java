package com.cibertec.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.ecommerce.model.DetalleOrden;
import com.cibertec.ecommerce.model.Orden;
import com.cibertec.ecommerce.model.Producto;
import com.cibertec.ecommerce.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	//declaramos variable tipo ProductoService, para traer todos los prod.@Autowired(para inyectar de contenedor de framework de la clase productoServce(
	@Autowired
	private ProductoService productoService;	
	
	private final Logger log= LoggerFactory.getLogger(HomeController.class);
	
	//2 objetos para el carrito, lista de detalles de orden (para almacenar detalles de la orden) y obj. Datos de la Orden
	List<DetalleOrden> detallesOrd = new ArrayList<DetalleOrden>();
	Orden orden = new Orden(); 
	
	
	//metodo para probar el index
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("productos", productoService.findAll());
		return"usuario/index";
	}
	
	//metodo para habilitar "VER PRODUCTO", respinde a peticiones tipo get - @GetMapping
	@GetMapping("productohome/{idProducto}")
	public String productoHome(@PathVariable Integer idProducto, Model model) {
		log.info("Id producto enviado como parámetro{}", idProducto);
		
		Producto producto = new Producto();
		Optional<Producto> productoOptional = productoService.get(idProducto);
		producto = productoOptional.get();
		
		model.addAttribute("producto", producto);
		return "usuario/productohome";
	}
	
	//metodo para el carrito de compras, Model nos permite llevar a la vista toda la info
	@PostMapping("/carro")
	public String addCart(@RequestParam Integer idProducto, @RequestParam Integer cantidad, Model model) {
		DetalleOrden detalleOrden = new DetalleOrden();
		Producto producto = new Producto();
		double sumaTotal =0;
		
		//buscamos el producto
		Optional<Producto> optionalProducto = productoService.get(idProducto);
		
		log.info("Producto añadido; {}", optionalProducto.get());
		log.info("Cantidad: {}", cantidad);
		producto=optionalProducto.get();
		
		detalleOrden.setCantidad(cantidad);
		detalleOrden.setPrecio(producto.getPrecio());
		detalleOrden.setNombre(producto.getNombre());
		detalleOrden.setTotal(producto.getPrecio()*cantidad);
		detalleOrden.setProducto(producto);
		
			
		detallesOrd.add(detalleOrden);
		
		sumaTotal = detallesOrd.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		orden.setTotal(sumaTotal);
		model.addAttribute("carro", detallesOrd);
		model.addAttribute("orden", orden);
		
		return"usuario/carrito";
	}
	
	//metodo para eliminar productos del carrito de compras
	@GetMapping("/eliminar/carro/{idProducto}")
	public String eliminarProductoCarro(@PathVariable Integer idProducto, Model model) {
		
		//hacemos una lista para retirar del carrito
		List<DetalleOrden> ordenNueva = new ArrayList<DetalleOrden>();
		
		for (DetalleOrden detalleOrden: detallesOrd) {
			if(detalleOrden.getProducto().getIdProducto()!= idProducto) {
				ordenNueva.add(detalleOrden);
			}
		}
		//actualiza la lista con los prod que no eliminamos
		detallesOrd=ordenNueva;
		
		double sumaTotal = 0;
		sumaTotal = detallesOrd.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		orden.setTotal(sumaTotal);
		model.addAttribute("carro", detallesOrd);
		model.addAttribute("orden", orden);
		
		return"usuario/carrito";
	}
	
	//METODO PARA ver resumen en carrito
	@GetMapping("/irCarro")
	public String irCarro(Model model) {
		
		model.addAttribute("carro", detallesOrd);
		model.addAttribute("orden", orden);
		
		return"usuario/carrito";
	}
	
	//***
	
	//METODO PARA BUSCAR UN PRODUCTO (busqueda por coincidencias)
	@PostMapping("/buscar")
	public String buscarProducto(@RequestParam String nombre, Model model) {
		log.info("nom prod: {}", nombre);
		List<Producto> productos = productoService.findAll().stream().filter(p -> 
		p.getNombre().contains(nombre)).collect(Collectors.toList());
		
		model.addAttribute("productos", productos);
		
		return"usuario/index";
	}
	
	
	
}

package com.cibertec.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.ecommerce.model.Producto;
import com.cibertec.ecommerce.repository.ProductoRepository;

//implementamos de la interfaz ProductoService
//definimos la clase como @Service para inyectar en el controlador esta clase para hacer el llamado a los metodos crud
@Service
public class ProductoServiceImplementacion implements ProductoService {
	
	//declaramos un objeto de la clase ProductoRepository, colocamos @Autowired, para indicar que estamos inyectando a la clase un objeto
	@Autowired
	private ProductoRepository productoRepository;
	
	
	@Override
	public Producto save(Producto producto) {
		// retorna, invocamos a productoRepository el cual llama al metodo save(), 
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
		// retorna, invocamos a  productoRepository el cual llama al metodo findByID()
		return productoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		//el metodo save() cuand al objeto lo mandas como id un null este lo crea, y cuando lo mandamos
		//con id que ya existe en la bd entoces lo que hace es actualizarlo
		productoRepository.save(producto);
		
	}

	@Override
	public void delete(Integer id) {
		//invocamos a productoRepository, con el metodo deleteByID()
		productoRepository.deleteById(id);
		
	}

	@Override
	public List<Producto> findAll() {
		
		return productoRepository.findAll();
	}
	
}

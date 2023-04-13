package com.cibertec.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.ecommerce.model.Producto;

//en esta interfaz definimos los metodos para el CRUD, que seran implementados en la clase ProductoServiceImplementacion
public interface ProductoService {
	//guardar
	public Producto save(Producto producto);
	// con optional para validar si el objeto que llamamos existe o no.
	public Optional<Producto> get(Integer id);
	//actualizar
	public void update(Producto producto);
	//metodo para eliminar
	public void delete(Integer id);
	//para listar productos
	public List<Producto> findAll();
}

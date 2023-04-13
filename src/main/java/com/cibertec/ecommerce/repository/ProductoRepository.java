package com.cibertec.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.ecommerce.model.Producto;

//heredamos de  JpaRepsitory, indicamos la tabla (Producto) y el tipo de Datto con el que se hara el crud,
//en este caso el id (es tipo int, po lo que llamamos al objeto Integer)

//usamos la siguiente notacion, el que es un aterfacto de spring, y hará la inyección 
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}

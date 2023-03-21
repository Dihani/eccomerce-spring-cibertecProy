package com.cibertec.ecommerce.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//5.0 PARA MAPEAR EN BASE DE DATOS LOS ATRIBUTOS AGREGAMOS ETIQUETAS @Entity @Table
@Entity
@Table(name="usuarios")

//1.0 creamos la clase usuario y sus atributos, estos deben mapearse en tablas en base de datos
public class Usuario {
	//6.0 indicaremos que el id sera autoincremental, 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//6.1 Si hay atributos que necesitas cambiar nombre o caracterisiticas 
	//determinadas en la bd puedes hacerlo desde aqui.
	private Integer idUsuario;
	private String nombre;
	private String userName;
	private String email;
	private String direccion;
	private String telefono;
	private String tipoUsuario;
	private String password;
	
	//8.0 creamos un atributo tipo producto, que devuelva una lista de productos
	//generamos su metodo get y set 
	//tendra una relacion de 1 a muchos, mapeado por el campo usuario(atributo de la clase Producto)
	@OneToMany(mappedBy = "usuario")
	private List<Producto> producto;
	
	//10.0 generamos una relación entre usaurio y orden
	//creamos un atributo tipo Orden que devuelva una lista
	//y mapeamos de uno a muchos por el campo usuario
	@OneToMany(mappedBy = "usuario")
	private List<Orden> ordenes;
	
	
	//1.1 generamos cpnstructor sin parametros
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	//1.2 generamos constructor con parametros
	
	public Usuario(Integer idUsuario, String nombre, String userName, String email, String direccion, String telefono,
			String tipoUsuario, String password) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.userName = userName;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipoUsuario = tipoUsuario;
		this.password = password;
	}
	//1.3 creamos los metodos getters and setters
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//1.4 metodo to String, lo que hace es retornar todos los campos de la clase como un string, 
		//para hacer las impresiones por consola

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", userName=" + userName + ", email=" + email
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", tipoUsuario=" + tipoUsuario + ", password="
				+ password + "]";
	}
	
}

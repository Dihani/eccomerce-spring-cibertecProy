package com.cibertec.ecommerce.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//4.0 crear clase DetalleOden y susa tributos
@Entity
@Table(name = "detalles")
public class DetalleOrden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleOrden;
	private String nombre;
	private double cantidad;
	private double precio;
	private double total;
	
	//13.0 creamos un atributo de tipo Orden y generamos sus metodo get y set
	//relacion de uno a uno
	@OneToOne
	private Orden orden;
	
	//14.0relacionamos producto y detalle orden
	//creamos atributo de tipo Producto y generamos sus metodo get y set
	//relacion de muchos a uno
	@ManyToOne
	private Producto producto;
	
	//4.1 creamos constructor sin parametros
	public DetalleOrden() {
		// TODO Auto-generated constructor stub
	}
	//4.2 creamos constructor con parametros

	public DetalleOrden(Integer idDetalleOrden, String nombre, double cantidad, double precio, double total) {
		super();
		this.idDetalleOrden = idDetalleOrden;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
	}
	//4.3creamos metodos get y set

	public Integer getIdDetalleOrden() {
		return idDetalleOrden;
	}

	public void setIdDetalleOrden(Integer idDetalleOrden) {
		this.idDetalleOrden = idDetalleOrden;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	//4.4 creamos metodo toString
	@Override
	public String toString() {
		return "DetalleOrden [idDetalleOrden=" + idDetalleOrden + ", nombre=" + nombre + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", total=" + total + "]";
	}
	
	
}

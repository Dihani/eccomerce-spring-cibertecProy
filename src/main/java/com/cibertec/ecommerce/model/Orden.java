package com.cibertec.ecommerce.model;

//3.0 creamos la clase Orden 

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "ordenes")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrden;
	private String numero;
	private Date fechaCreacion;
	private Date fechaRecibida;
	private double total;
	
	
	//9.0 creamos una tributo de tipo Usuario, generamos sus metodos get y set
	//11.0 indicar relacion de muchos a uno con la table usuarios
	@ManyToOne
	private Usuario usuario;
	
	//12.0 relacionamos orden con detalleOrden
	//12.1 creamos un atributo de tipo DetalleOrden
	//relacion uno a uno
	@OneToOne(mappedBy = "orden")
	private DetalleOrden detalle;
	
	//3.1 constructor sin parametros
	public Orden() {
		// TODO Auto-generated constructor stub
	}
	//3.2 constructor con parametros
	
	public Orden(Integer idOrden, String numero, Date fechaCreacion, Date fechaRecibida, double total) {
		super();
		this.idOrden = idOrden;
		this.numero = numero;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibida = fechaRecibida;
		this.total = total;
	}
	
	//3.3 crear metodos get y set de todos los atributos

	public Integer getIdOrden() {
		return idOrden;
	}

	
	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaRecibida() {
		return fechaRecibida;
	}

	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	


	public DetalleOrden getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleOrden detalle) {
		this.detalle = detalle;
	}

	
	
	//2.4 metodo to String

	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", numero=" + numero + ", fechaCreacion=" + fechaCreacion
				+ ", fechaRecibida=" + fechaRecibida + ", total=" + total + "]";
	}
	
}

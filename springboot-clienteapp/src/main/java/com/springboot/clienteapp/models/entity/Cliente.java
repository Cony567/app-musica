	package com.springboot.clienteapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
//Clase entidad de Cliente, última modificación 28 de enero de 2022, Constanza Castillo
//a nivel de clase se encuentra la anotación de la tabla correspondiente a la que hace referencia en la base de datos
//implementa la interfaz Serializable
@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	/**
	 * Definición de atributos de la clase, en la parte superior y a nivel de atributos se encuentran todos las anitaciones para validación
	 */
	private static final long serialVersionUID = 1L;
	@Id//anotación para identificar el atributo clave principal de la entidad
	@GeneratedValue(strategy=GenerationType.IDENTITY)//para atributos autoincrementales
	private Long id_cliente;//atributo de la tabla llamado = id_cliente, autoincremental y que además es la PK de la tabla 'Clientes'
	@NotEmpty(message = "El nombre no puede ser vacio")//anotación que no permite ingresar valores vacios para un texto
	@Length(min = 3, max = 45)//anotación que pide un largo especifico a una cadena de texto, en este caso mínimo 3 y máximo 45, esto puede o no tener relación a los requerimientos de la base de datos
	private String nombres;//atributo de la tabla llamado = nombres
	@NotEmpty(message = "El apellido no puede ser vacio")
	@Length(min = 3, max = 45)
	private String apellidos;//atributo de la tabla llamado = apellidos
	//@NotEmpty(message = "El teléfono no puede ser vacio")
	//@Pattern(regexp="^[0-9]{9}-[0-9]{8}", message = "Para el teléfono debe ingresar valores numéricos")
	@Max(value=999999999, message="El número no puede tener más de 9 dígitos")//anotación que pide un valor máximo para un atributo int o numérico, se le hace también un cambio de mensaje
	@Min(value=100000000, message="El número no tiene el formáto mínimo de dígitos")//anitación que necesita que el valor cumpla con un número mínimo para ser válido, mensajes 
	private int telefono;
	@NotEmpty(message = "El correo no puede ser vacio")
	@Email
	@Length(min = 3, max = 45)
	private String email;
	@ManyToOne
	@JoinColumn(name="id_ciudades")
	private Ciudad ciudad;
	
	//Métodos de get para la obtención de distintos atributos de la entidad determinada, Cliente
	public Long getId_cliente() {
		return id_cliente;
	}

	//Métodos de Set para el cambio de valor del atributo en cuestión de la entidad Cliente
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Ciudad getCiudad() {
		return ciudad;
	}


	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}


	//sobre escritura del método toString, retorna los datos correspondientes a cada atributo de la entidad.
	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", email=" + email + ", ciudad=" + ciudad + "]";
	}

}

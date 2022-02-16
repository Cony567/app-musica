package com.springboot.clienteapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Clase entidad de Cliente, última modificación 25 de enero de 2022, Constanza Castillo
//a nivel de clase se encuentra la anotación de la tabla correspondiente a la que hace referencia en la base de datos
//implementa la interfaz Serializable
@Entity
@Table(name="generos")
public class Genero implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id//anotación para identificar el atributo clave principal de la entidad
	@GeneratedValue(strategy=GenerationType.IDENTITY)//para atributos autoincrementales
	private Long id_genero;//atributo de la tabla llamado = id_genero, autoincremental y que además es la PK de la tabla 'Clientes'
	
	private String nombre;

	public Long getId_genero() {
		return id_genero;
	}

	public void setId_genero(Long id_genero) {
		this.id_genero = id_genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

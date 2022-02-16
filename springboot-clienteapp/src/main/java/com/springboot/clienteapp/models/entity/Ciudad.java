package com.springboot.clienteapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//
//Clase entidad de Ciudad, última modificación 24 de enero 2022, Constanza Castillo
//a nivel de clase se encuentra la anotación de la tabla correspondiente a la que hace referencia en la base de datos
//implementa la interfaz Serializable
@Entity
@Table(name="ciudades")
public class Ciudad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id//anotación para identificar el atributo clave principal de la entidad
	@GeneratedValue(strategy=GenerationType.IDENTITY)//indica que es el valor identificador
	private Long id_ciudades;//atributo de la tabla llamado = id_ciudad, autoincremental y que además es la PK de la tabla 'Ciudades'
	private String ciudad;//atributo de la tabla llamado = ciudad, contiene el nombre de la ciudad
	//Métodos de get para la obtención de distintos atributos de la entidad determinada
	public Long getId_ciudades() {
		return id_ciudades;
	}
	//Métodos de Set para el cambio de valor del atributo en cuestión de la entidad Ciudad
	public void setId_ciudades(Long id_ciudades) {
		this.id_ciudades = id_ciudades;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Ciudad [id_ciudades=" + id_ciudades + ", ciudad=" + ciudad + "]";
	}

}

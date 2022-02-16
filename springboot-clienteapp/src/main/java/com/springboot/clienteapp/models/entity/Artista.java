package com.springboot.clienteapp.models.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="artistas")
public class Artista implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_artista;
	@NotEmpty(message = "El nombre no puede ser vacio")
	@Length(min = 3, max = 100)
	private String nombre;
	@NotEmpty(message = "Debe ingresar el link de una imagen")
	private String link_imagen;
	@ManyToOne
	@JoinColumn(name="id_genero")
	private Genero genero;

	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@NotNull(message="Porfavor Ingrese una fecha")
	//@Past(message="Debe ingresar una fecha anterior a la de hoy")
	private Date fecha_nac;

	public Long getId_artista() {
		return id_artista;
	}

	public void setId_artista(Long id_artista) {
		this.id_artista = id_artista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getLink_imagen() {
		return link_imagen;
	}

	public void setLink_imagen(String link_imagen) {
		this.link_imagen = link_imagen;
	}
	
	@Override
	public String toString() {
		return "Artista [id_artista=" + id_artista + ", nombre=" + nombre + ", link_imagen=" + link_imagen + ", genero="
				+ genero + ", fecha_nac=" + fecha_nac + "]";
	}
	
}

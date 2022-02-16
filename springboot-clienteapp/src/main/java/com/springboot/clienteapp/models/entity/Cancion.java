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

@Entity
@Table(name="canciones")
public class Cancion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_cancion;
	@ManyToOne
	@JoinColumn(name="id_album")
	private Album album;
	
	@NotEmpty(message = "El nombre no puede ser vacio")
	private String nombre;

	private Date fecha_lanz;
	
	private String link_cancion;
	
	public Long getId_cancion() {
		return id_cancion;
	}

	public void setId_cancion(Long id_cancion) {
		this.id_cancion = id_cancion;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_lanz() {
		return fecha_lanz;
	}

	public void setFecha_lanz(Date fecha_lanz) {
		this.fecha_lanz = fecha_lanz;
	}

	public String getLink_cancion() {
		return link_cancion;
	}

	public void setLink_cancion(String link_cancion) {
		this.link_cancion = link_cancion;
	}

	
}

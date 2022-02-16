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

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="albumes")
public class Album implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_album;
	@ManyToOne
	@JoinColumn(name="id_artista")
	private Artista artista;
	
	@NotEmpty(message = "El nombre no puede ser vacio")
	@Length(min = 1, max = 100)
	private String nombre;
	//@Past
	private Date fecha_lanz;

	public Long getId_album() {
		return id_album;
	}

	public void setId_album(Long id_album) {
		this.id_album = id_album;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
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

	@Override
	public String toString() {
		return "Album [id_album=" + id_album + ", artista=" + artista + ", nombre=" + nombre + ", fecha_lanz="
				+ fecha_lanz + "]";
	}
}

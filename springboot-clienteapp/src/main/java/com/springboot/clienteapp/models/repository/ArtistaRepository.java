package com.springboot.clienteapp.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.clienteapp.models.entity.Artista;
import com.springboot.clienteapp.models.entity.Genero;

public interface ArtistaRepository extends CrudRepository<Artista, Long> {

	//buscar todos los artistas que tengan cierto nombre 
	List<Artista> findByNombreLike(String nombre);
	//buscar artista por género
	List<Artista> findByGenero(Genero genero);
}

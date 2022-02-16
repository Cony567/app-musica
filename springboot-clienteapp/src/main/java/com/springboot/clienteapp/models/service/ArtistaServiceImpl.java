package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Artista;
import com.springboot.clienteapp.models.entity.Genero;
import com.springboot.clienteapp.models.repository.ArtistaRepository;
import com.springboot.clienteapp.models.repository.GeneroRepository;

@Service
public class ArtistaServiceImpl implements IArtistaService {
	//autowired de los repositorios
	@Autowired
	private ArtistaRepository artistaR;
	@Autowired
	private GeneroRepository generoR;
	
	// métodos a sobrescribir de la interfaz servicio de artista
	@Override
	// lista todos los artistas que se encuentran en la base de datos
	public List<Artista> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Artista>) artistaR.findAll();
	}

	@Override// guardar los cambios de un artista
	public void guardar(Artista artista) {
		artistaR.save(artista);

	}

	@Override // buscar artista por id
	public Artista buscarPorId(Long id) {
		
		return artistaR.findById(id).orElse(null);
	}

	@Override // eliminar artista por id
	public void eliminar(Long id) {
		artistaR.deleteById(id);

	}

	@Override// buscar artista por nombre 
	public List<Artista> buscarPorNombre(String nombre) {

		return artistaR.findByNombreLike(nombre);
	}

	@Override // buscar artista por género
	public List<Artista> buscarPorGenero(Genero genero) {

		return artistaR.findByGenero(genero);
	}

}

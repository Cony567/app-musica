package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Artista;
import com.springboot.clienteapp.models.entity.Genero;

public interface IArtistaService {
	//listar todos los artistas
	public List<Artista> listarTodos();
	//guarda un artista
	public void guardar(Artista artista);
	//buscar artista por id de artista
	public Artista buscarPorId(Long id);
	//eliminar artista
	public void eliminar(Long id);
	//buscar artista por nombre 
	public List<Artista> buscarPorNombre(String nombre);
	//buscar artista por género
	public List<Artista> buscarPorGenero(Genero genero);

}

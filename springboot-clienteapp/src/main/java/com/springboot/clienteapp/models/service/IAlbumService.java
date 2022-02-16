package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Album;

public interface IAlbumService {
	public List<Album> listarTodos();
	public List<Album> listarPorArtista(Long id_artista);
	public void guardar(Album album);
	public Album buscarPorId(Long id);
	public void eliminar(Long id);
	
}

package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Cancion;

public interface ICancionService {
	public List<Cancion> listarTodos();
	public void guardar(Cancion cancion);
	public Cancion buscarPorId(Long id);
	public void eliminar(Long id);
}

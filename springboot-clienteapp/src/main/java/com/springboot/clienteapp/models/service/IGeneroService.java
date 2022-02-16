package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Genero;

public interface IGeneroService {

	public List<Genero> listaGeneros();
	public Genero buscarPorId(Long id);
}

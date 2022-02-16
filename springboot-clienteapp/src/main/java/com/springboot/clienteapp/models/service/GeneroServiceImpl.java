package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Genero;
import com.springboot.clienteapp.models.repository.GeneroRepository;

@Service
public class GeneroServiceImpl implements IGeneroService {

	@Autowired
	private GeneroRepository generoR;
	@Override
	public List<Genero> listaGeneros() {
		// TODO Auto-generated method stub
		return (List<Genero>) generoR.findAll();
	}
	@Override
	public Genero buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return generoR.findById(id).orElse(null);
	}

}

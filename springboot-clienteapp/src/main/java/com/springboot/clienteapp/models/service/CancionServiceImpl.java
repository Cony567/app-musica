package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Cancion;
import com.springboot.clienteapp.models.repository.CancionRepository;

@Service
public class CancionServiceImpl implements ICancionService {

	@Autowired
	private CancionRepository cancionR;
	@Override
	public List<Cancion> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Cancion>) cancionR.findAll();
	}

	@Override
	public void guardar(Cancion cancion) {
		cancionR.save(cancion);

	}

	@Override
	public Cancion buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return cancionR.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		cancionR.deleteById(id);

	}

}

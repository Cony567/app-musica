package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Cliente;
import com.springboot.clienteapp.models.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private ClienteRepository clienteR;
	@Override
	public List<Cliente> listarTodos() {
		return (List<Cliente>) clienteR.findAll();
	}

	@Override
	public void guardar(Cliente cliente) {
		clienteR.save(cliente);
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return clienteR.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		clienteR.deleteById(id);

	}

}

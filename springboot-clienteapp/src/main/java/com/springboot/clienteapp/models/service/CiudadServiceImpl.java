package com.springboot.clienteapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Ciudad;
import com.springboot.clienteapp.models.repository.CiudadRepository;

@Service// esto es muy importante nos puede tirar error si nosotros no ocupamos las anotaciones
public class CiudadServiceImpl implements ICiudadService {

	@Autowired
	private CiudadRepository ciudadR;
	@Override
	public List<Ciudad> listaCiudades() {
		// TODO Auto-generated method stub
		return (List<Ciudad>) ciudadR.findAll();
	}

}

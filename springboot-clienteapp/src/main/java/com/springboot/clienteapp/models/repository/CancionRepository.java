package com.springboot.clienteapp.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.clienteapp.models.entity.Cancion;

public interface CancionRepository extends CrudRepository<Cancion, Long> {

}

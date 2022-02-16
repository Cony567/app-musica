package com.springboot.clienteapp.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.clienteapp.models.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}

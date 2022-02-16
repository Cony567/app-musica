package com.springboot.clienteapp.models.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.springboot.clienteapp.models.entity.Album;


public interface AlbumRepository extends CrudRepository<Album, Long> {

}

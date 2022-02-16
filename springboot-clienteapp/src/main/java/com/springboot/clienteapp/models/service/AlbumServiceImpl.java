package com.springboot.clienteapp.models.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Album;
import com.springboot.clienteapp.models.repository.AlbumRepository;
@Service
public class AlbumServiceImpl implements IAlbumService {

	@Autowired
	private AlbumRepository albumR;
	@Override
	public List<Album> listarTodos() {
		return (List<Album>) albumR.findAll();
	}
	public List<Album> listarPorArtista(Long id_artista) {
		List<Album> listaCompleta = (List<Album>) albumR.findAll();
		List<Album> listaF = new ArrayList<Album>() {
			{
				for(int i=0; i< listaCompleta.size();i++) {
					Album al = listaCompleta.get(i);
					if(al.getArtista().getId_artista() == id_artista) {
						add(listaCompleta.get(i));
					}
					 
				}
			}
		};
		
		
		return (List<Album>) listaF;
		
		
	}

	@Override
	public void guardar(Album album) {
		albumR.save(album);

	}

	@Override
	public Album buscarPorId(Long id) {
		return albumR.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		albumR.deleteById(id);

	}

}

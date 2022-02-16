package com.springboot.clienteapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.clienteapp.models.entity.Album;
import com.springboot.clienteapp.models.entity.Artista;
import com.springboot.clienteapp.models.entity.Genero;
import com.springboot.clienteapp.models.service.AlbumServiceImpl;
import com.springboot.clienteapp.models.service.ArtistaServiceImpl;

@Controller
@RequestMapping("/discos")
public class AlbumController {

	@Autowired
	private AlbumServiceImpl albumService;
	@Autowired
	private ArtistaServiceImpl artistaService;
	
	/*última modificación, 28 de enero de 2022, Lo que hace este módulo es listar todos los artistas que se encuentran en la base de datos*/
	@GetMapping("/")
	public String listarArtistas(Model model) {
		List<Album> listaAlbum = albumService.listarTodos();

		model.addAttribute("titulo", "Lista de Álbums");
		if (listaAlbum != null) {
			model.addAttribute("albums", listaAlbum);
		}
		return "/views/albums/listarAlb";
	}
	
	/*última modificación, 28 de enero de 2022, Lo que hace este módulo es retornar la página del formulario para crear un artistas*/
	@GetMapping("/crear/{id_artista}")
	public String envioFormulario(Model model, @PathVariable("id_artista") Long idArtista) {
		Album album = new Album();
		Artista artista = artistaService.buscarPorId(idArtista);
		if(artista == null){
			model.addAttribute("error", "No se puede crear un álbum asociado a un artista que no exite");
			return "/errores/vista_no_encontrado";
		}
		model.addAttribute("titulo", "Nuevo Álbum Para ");
		model.addAttribute("artista", artista);
		model.addAttribute("album", album);
		
		return "/views/albums/frmAlbum";
	}
	/*última modificación, 28 de enero de 2022, Lo que hace este módulo es guardar a nuestro nuevo usuario, y en caso de que haya o exista algún
	 * Error de validación entonces*/
	@PostMapping("/guardar/{id_artista}")
	public String guardar(@PathVariable("id_artista") Long idArtista, @Valid @ModelAttribute Album album, BindingResult result, Model model) {
		
		
		try {
			Artista artista = artistaService.buscarPorId(idArtista);
			System.out.print("Print de fecha" + album.getFecha_lanz());
			if (result.hasErrors()) {
				System.out.println(artista.getFecha_nac());
				if(album.getFecha_lanz() == null) {
					System.out.println("está adentro");
					model.addAttribute("error_fecha", "La fecha no puede ser nula");
				}/*
				if(album.getNombre() == "") {
					System.out.print("validador de nombre");
					model.addAttribute("error_nombre", "El nombre no puede ser vacío");
				}*/
				model.addAttribute("titulo", "Guardar Álbum de ");
				model.addAttribute("artista", artista);
				model.addAttribute("album", album);
				return "/views/albums/frmAlbum";
			}
			
			album.setArtista(artista);
			albumService.guardar(album);
			return "redirect:/artistas/";
		}catch(Exception ex){
			model.addAttribute("error", "No se pueden guardar los cambios del álbum de un artista que no existe.");
			return "/errores/vista_no_encontrado";
		}
	}
	
}

package com.springboot.clienteapp.controller;

import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.clienteapp.models.entity.Album;
import com.springboot.clienteapp.models.entity.Artista;
import com.springboot.clienteapp.models.entity.Genero;
import com.springboot.clienteapp.models.service.AlbumServiceImpl;
import com.springboot.clienteapp.models.service.ArtistaServiceImpl;
import com.springboot.clienteapp.models.service.GeneroServiceImpl;

@Controller
@RequestMapping("/artistas")
public class ArtistaController {
	private static Logger log_ = LoggerFactory.getLogger(ArtistaController.class);
	
	@Autowired
	private ArtistaServiceImpl artistaService;
	@Autowired
	private GeneroServiceImpl generoService;
	@Autowired
	private AlbumServiceImpl albumService;
	//listar todos los artistas
	@GetMapping("/")
	public String listarArtistas(Model model) {
		List<Artista> listaArtistas = artistaService.listarTodos();
		List<Genero> generos = generoService.listaGeneros();
		model.addAttribute("titulo", "Lista de Artistas");
		model.addAttribute("artistas", listaArtistas);
		model.addAttribute("artista", new Artista());
		model.addAttribute("generos", generos);
		return "/views/artistas/listarArt";
	}
	
	//buscar artistas por nombre del artista
	@GetMapping("/buscar")
	public String listarArtistasPorNombre(@RequestParam(value="nombre",required=false) String nombre,
			@ModelAttribute Artista artista,Model model) {
		nombre = "%" + nombre + "%";
		List<Artista> listaArtistas = artistaService.buscarPorNombre(nombre);
		List<Genero> generos = generoService.listaGeneros();
		model.addAttribute("titulo", "Lista de Artistas");
		model.addAttribute("artista", artista);
		model.addAttribute("artistas", listaArtistas);
		model.addAttribute("generos", generos);
		//validar que sea null,, si la respuesta es nula o de largo 0 retorna un mensaje de vacío
		if(listaArtistas == null || listaArtistas.size() == 0) {
			model.addAttribute("sin_resultado", "No se han encontrado resultados para esta búsqueda");
		}
		return "/views/artistas/listarArt";
	}
	
	//buscar artistas por genero 
	@GetMapping("/buscar/genero/{id}")
	public String listarArtistasPorGenero(@PathVariable("id") Long idGenero,
			@ModelAttribute Artista artista,Model model) {
		Genero genero = generoService.buscarPorId(idGenero);
		List<Artista> listaArtistas = artistaService.buscarPorGenero(genero);
		List<Genero> generos = generoService.listaGeneros();
		model.addAttribute("titulo", "Lista de Artistas");
		model.addAttribute("artista", artista);
		model.addAttribute("artistas", listaArtistas);
		model.addAttribute("generos", generos);
		if(listaArtistas == null || listaArtistas.size() == 0) {
			model.addAttribute("sin_resultado", "No se han encontrado resultados para esta búsqueda");
		}
		return "/views/artistas/listarArt";
	}
	
	//envío de formulario para creación de artista
	@GetMapping("/crear")
	public String envioFormulario(Model model) {
		List<Genero> listaGeneros = generoService.listaGeneros();
		Artista artista = new Artista();
		model.addAttribute("titulo", "Nuevo Artista");
		model.addAttribute("artista",artista);
		model.addAttribute("generos",listaGeneros);
		
		return "/views/artistas/frmArt";
	}

	//guardar cambios de artista o nuevo artista
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute Artista artista, BindingResult result, Model model) {
		

		List<Genero> listaGeneros = generoService.listaGeneros();
		if (result.hasErrors()) {
			System.out.println(artista.getFecha_nac());
			//validacion de fecha, para que no sea nulo
			if(artista.getFecha_nac() == null) {
				model.addAttribute("error_fecha", "La fecha no puede ser nula");
			}
			model.addAttribute("titulo", "Registrando Nuevo Artista");
			model.addAttribute("artista", artista);
			model.addAttribute("generos", listaGeneros);
			return "/views/artistas/frmArt";
		}
		
		artistaService.guardar(artista);
		return "redirect:/artistas/";
		
	}
	
	//ver artista por id, con sus correspondientes álbumes
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable("id") Long idArtista,Model model) {
		
		try {
			Artista artista = artistaService.buscarPorId(idArtista);
			List<Album> albumsLista = albumService.listarPorArtista(idArtista);
			
			model.addAttribute("titulo", "Vista y acciones de Artista");
			model.addAttribute("artista", artista);
			//Valida que el artista tenga albumes asociados, en caso contrario
			if(albumsLista.size() != 0) {
				model.addAttribute("albums", albumsLista);
			}
			System.out.println(artista.toString());
			System.out.println(albumsLista);
			
			
			return "/views/artistas/verArt";
		}catch (Exception ex) {
			model.addAttribute("error", "No se ha podido encontrar al artista");
			return "/errores/vista_no_encontrado";
		}
	}
	
	//envía el formulario del artista pero con un artista ya creado 
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idArtista, Model model) {
		try {
			Artista artista = artistaService.buscarPorId(idArtista);
			List<Genero> listaGeneros = generoService.listaGeneros();
			
			model.addAttribute("titulo", "Editar Artista");
			model.addAttribute("artista", artista);
			model.addAttribute("generos", listaGeneros);
			
			if(artista == null){
				model.addAttribute("error", "No se puede editar un artista que no exite");
				return "/errores/vista_no_encontrado";
			}
			return "/views/artistas/frmArt";
		}catch(Exception ex) {
			model.addAttribute("error", "Ocurrió un error inesperado");
			return "/errores/vista_no_encontrado";
		}
		
	}
	
	//elimina un artista, si no tiene álbumes
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long idArtista, Model model) {
		try {
			List<Album> albumsLista = albumService.listarPorArtista(idArtista);
			if(albumsLista.size() != 0) {
				model.addAttribute("titulo", "Eliminarción de artista");
				Artista artista = artistaService.buscarPorId(idArtista);
				model.addAttribute("artista", artista);
				model.addAttribute("albums", albumsLista);
				model.addAttribute("error", "No se Puede Eliminar");
				return "/views/artistas/verArt";
			}
			artistaService.eliminar(idArtista);
			System.out.println("Artista eliminado");
			return "redirect:/artistas/";
		}catch (Exception ex) {
			model.addAttribute("error", "No se puede eliminar un artista que no existe");
			return "/errores/vista_no_encontrado";
		}
		
	}
	
	
	
}

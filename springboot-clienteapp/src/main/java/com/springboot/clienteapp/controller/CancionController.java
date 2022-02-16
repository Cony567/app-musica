package com.springboot.clienteapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.clienteapp.models.entity.Cancion;
import com.springboot.clienteapp.models.service.CancionServiceImpl;

@Controller
@RequestMapping("/canciones")
public class CancionController {

	@Autowired
	private CancionServiceImpl cancionService;
	
	@GetMapping("/")
	public String listarArtistas(Model model) {
		List<Cancion> listaCanciones = cancionService.listarTodos();

		model.addAttribute("titulo", "Lista de Canciones");
		if (listaCanciones != null) {
			model.addAttribute("Canciones", listaCanciones);
		}
		System.out.println(listaCanciones);
		return "/views/canciones/listarCan";
	}
}

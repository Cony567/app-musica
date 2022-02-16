package com.springboot.clienteapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.clienteapp.models.entity.Ciudad;
import com.springboot.clienteapp.models.entity.Cliente;
import com.springboot.clienteapp.models.service.ICiudadService;
import com.springboot.clienteapp.models.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private ICiudadService ciudadService;
	
	@GetMapping("/")
	public String listarClientes(Model model) {
		List<Cliente> listaClientes = clienteService.listarTodos();
		model.addAttribute("titulo", "Lista de clientes");
		model.addAttribute("clientes", listaClientes);
		System.out.println(listaClientes);
		return "/views/clientes/listar";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		List<Ciudad> listCiudades = ciudadService.listaCiudades();
		
		model.addAttribute("titulo", "Crear Cliente");
		model.addAttribute("cliente", cliente);
		model.addAttribute("ciudades", listCiudades);
		return "/views/clientes/frmCrear";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model) {

		List<Ciudad> listCiudades = ciudadService.listaCiudades();
		if (result.hasErrors()) {
			System.out.println(cliente.getTelefono());
			System.out.println(result.toString());
			model.addAttribute("titulo", "Crear Cliente");
			model.addAttribute("cliente", cliente);
			model.addAttribute("ciudades", listCiudades);
			return "/views/clientes/frmCrear";
		}
		
		clienteService.guardar(cliente);
		return "redirect:/clientes/";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable("id") Long idCliente,Model model) {
		Cliente cliente = clienteService.buscarPorId(idCliente);
		if(cliente == null) {
			model.addAttribute("error", "No se ha encontrado este cliente.");
			return "/errores/vista_no_encontrado";
		}
		model.addAttribute("titulo", "Ver Cliente");
		model.addAttribute("cliente", cliente);
		return "/views/clientes/vistaCliente";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idCliente,Model model) {
		Cliente cliente = clienteService.buscarPorId(idCliente);
		List<Ciudad> listCiudades = ciudadService.listaCiudades();
		
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("cliente", cliente);
		model.addAttribute("ciudades", listCiudades);
		if(cliente == null) {
			model.addAttribute("error", "No se ha encontrado este cliente Para su edición");
			return "/errores/vista_no_encontrado";
		}
		return "/views/clientes/frmCrear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long idCliente, Model model) {
		try {
			clienteService.eliminar(idCliente);
			return "redirect:/clientes/";
		} catch (Exception ex) {
			model.addAttribute("error", "No se ha ha podido eliminar a este Cliente, por su inexistencia.");
			return "/errores/vista_no_encontrado";
		}

	}
}

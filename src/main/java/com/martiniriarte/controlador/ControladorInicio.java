package com.martiniriarte.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.martiniriarte.modelo.Persona;
import com.martiniriarte.servicio.PersonaServicio;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {

	@Autowired
	private PersonaServicio personaServicio;

	@GetMapping("/") // El segundo parametro trae al usuario que se loguea.
	public String inicio(Model model, @AuthenticationPrincipal User user) {

		var personas = personaServicio.listarPersonas();

		log.info("ejecutando el controlador Spring MVC");
		log.info("usuario que hizo login: " + user);
		model.addAttribute("personas", personas);
		return "index";
	}

	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "modificar";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid Persona persona, Errors errores) {
		if (errores.hasErrors()) {
			return "modificar";
		}
		personaServicio.guardar(persona);
		return "redirect:/";
	}

	@GetMapping("/editar/{idPersona}")
	public String editar(Persona persona, Model modelo) {
		persona = personaServicio.buscarPersona(persona);
		modelo.addAttribute("persona", persona);
		return "modificar";
	}

	@GetMapping("/eliminar")
	public String eliminar(Persona persona) {
		personaServicio.eliminar(persona);
		return "redirect:/";
	}
}

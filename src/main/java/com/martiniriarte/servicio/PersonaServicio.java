package com.martiniriarte.servicio;

import java.util.List;

import com.martiniriarte.modelo.Persona;

public interface PersonaServicio {
	
	public List<Persona> listarPersonas();

	public void guardar(Persona persona);

	public void eliminar(Persona persona);

	public Persona buscarPersona(Persona persona);
}

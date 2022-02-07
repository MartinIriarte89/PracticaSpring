package com.martiniriarte.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martiniriarte.dao.PersonaDao;
import com.martiniriarte.modelo.Persona;

@Service
public class PersonaServicioImpl implements PersonaServicio {

	@Autowired
	private PersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> listarPersonas() {
		return   (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	@Transactional
	public void eliminar(Persona persona) {
		personaDao.delete(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona buscarPersona(Persona persona) {
		return personaDao.findById(persona.getIdPersona()).orElse(null);
	}

}

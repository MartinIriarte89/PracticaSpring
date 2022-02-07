package com.martiniriarte.dao;

import org.springframework.data.repository.CrudRepository;

import com.martiniriarte.modelo.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long> {

}

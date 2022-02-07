package com.martiniriarte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martiniriarte.modelo.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	//Este metodo debe llamarse asi!!
	Usuario findByUsername(String username);
}

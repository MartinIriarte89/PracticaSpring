package com.martiniriarte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martiniriarte.modelo.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	Usuario buscarPorUsuario(String usuario);
}

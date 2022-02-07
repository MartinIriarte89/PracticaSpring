package com.martiniriarte.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@NotEmpty
	private String usuario;

	@NotEmpty
	private String contrasena;

	@OneToMany
	@JoinColumn(name = "id_usuario")
	private List<Rol> roles;
}

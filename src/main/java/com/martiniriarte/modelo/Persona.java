package com.martiniriarte.modelo;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;

@Entity
@Data
@Table(name="persona")
public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;
	
	private String telefono;
	
	@NotNull
	private Double saldo;
}

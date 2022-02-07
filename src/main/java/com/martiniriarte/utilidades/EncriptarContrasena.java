package com.martiniriarte.utilidades;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarContrasena {

	public static void main(String[] args) {
		String password = "123";
		System.out.println("Password sin encriptar: " + password);
		System.out.println("Password encriptado: " + encriptarContrasena(password));
	}

	public static String encriptarContrasena(String password) {
		BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder();
		return encriptador.encode(password);
	}
}

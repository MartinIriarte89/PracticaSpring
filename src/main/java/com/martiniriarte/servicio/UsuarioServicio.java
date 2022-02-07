package com.martiniriarte.servicio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martiniriarte.dao.UsuarioDao;
import com.martiniriarte.modelo.Rol;
import com.martiniriarte.modelo.Usuario;

@Service("userDetailsService")
public class UsuarioServicio implements UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	
	//Recupera al usuario de la BBDD y crea el objeto user con los datos de mi usuario para
	//que spring pueda usar su seguridad de login.
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario =  usuarioDao.buscarPorUsuario(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		
		//Los roles deben ser pasados al "User" envueltos en capa de interface GrantedAuthority
		var roles = new ArrayList<GrantedAuthority>();
		
		for (Rol rol : usuario.getRoles()) {
			// SimpleGrantedAuthority implementa la interfaz GrantedAuthority
			// Y por eso la usamos para instanciar
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		
		//Objeto user de Spring
		return new User(usuario.getUsuario(), usuario.getContrasena(), roles);
	}
	
}

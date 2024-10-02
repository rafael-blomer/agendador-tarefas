package com.example.agendadortarefas.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.agendadortarefas.business.dto.UsuarioDTO;
import com.example.agendadortarefas.infrastructure.client.UsuarioClient;

@Service
public class UserDetailsServiceImpl {
	
	@Autowired
	private UsuarioClient client;

	
	public UserDetails carregaDadosDeUsuario(String email, String token) {
		UsuarioDTO dto = client.buscaUsuarioPorEmail(email, token);
		return User
		.withUsername(dto.getEmail()) 
		.password(dto.getSenha()) 
		.build(); 
	}
}

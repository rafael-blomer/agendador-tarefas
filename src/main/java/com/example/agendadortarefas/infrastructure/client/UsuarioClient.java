package com.example.agendadortarefas.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.agendadortarefas.business.dto.UsuarioDTO;


@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

	@GetMapping("/usuario")
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email, @RequestHeader("Authorization") String token);

}

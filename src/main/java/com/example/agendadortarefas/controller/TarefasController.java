package com.example.agendadortarefas.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.agendadortarefas.business.TarefasService;
import com.example.agendadortarefas.business.dto.TarefasDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

	@Autowired
	private final TarefasService service;
	
	@PostMapping
	public ResponseEntity<TarefasDTO> gravarTarefa(@RequestBody TarefasDTO dto, @RequestHeader("Authorization") String token) {
		return ResponseEntity.ok(service.gravarTarefa(token, dto));
	}
	
	@GetMapping("/eventos")
	public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasPorPeriodo(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {
		return ResponseEntity.ok(service.buscarTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
	}
	
	@GetMapping
	public ResponseEntity<List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader("Authorization") String token) {
		return ResponseEntity.ok(service.buscaTarefasPorEmail(token));
	}
}

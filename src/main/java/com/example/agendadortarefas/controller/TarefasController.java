package com.example.agendadortarefas.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.agendadortarefas.business.TarefasService;
import com.example.agendadortarefas.business.dto.TarefasDTO;
import com.example.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;

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
	
	@DeleteMapping
	public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id) {
		service.deletaTarefaPorId(id);
		return ResponseEntity.ok().build();
	}
	
	@PatchMapping
	public ResponseEntity<TarefasDTO> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status, @RequestParam("id")String id) {
		return ResponseEntity.ok(service.alteraStatus(status, id));
	}
	
	@PutMapping
	public ResponseEntity<TarefasDTO> updateTarefas(@RequestBody TarefasDTO dto, @RequestParam("id") String id) {
		return ResponseEntity.ok(service.updateTarefas(dto, id));
	}
}

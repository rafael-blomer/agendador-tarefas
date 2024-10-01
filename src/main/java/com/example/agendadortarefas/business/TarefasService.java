package com.example.agendadortarefas.business;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agendadortarefas.business.dto.TarefasDTO;
import com.example.agendadortarefas.business.mapper.TarefasConverter;
import com.example.agendadortarefas.infrastructure.entity.Tarefas;
import com.example.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.example.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.example.agendadortarefas.infrastructure.security.JwtUtil;

@Service
public class TarefasService {

	@Autowired
	private TarefasRepository repo;
	private TarefasConverter converter;
	@Autowired
	private JwtUtil util;
	
	
	public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
		dto.setEmailUsuario(util.extrairEmailToken(token.substring(7)));
		dto.setDataCriacao(LocalDateTime.now());
		dto.setStatus(StatusNotificacaoEnum.PENDENTE);
		Tarefas entity =converter.paraTarefaEntity(dto);
		return converter.paraTarefaDTO(repo.save(entity));
	}
	
	public List<TarefasDTO> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal){
		return converter.paraListTarefasDto(repo.findByDataEventoBetween(dataInicial, dataFinal));
	}
	
	public List<TarefasDTO> buscaTarefasPorEmail(String token) {
		String email = util.extrairEmailToken(token.substring(7));
		return converter.paraListTarefasDto(repo.findByEmailUsuario(email));
	}
}

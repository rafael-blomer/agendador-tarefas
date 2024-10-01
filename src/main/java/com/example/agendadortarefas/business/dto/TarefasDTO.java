package com.example.agendadortarefas.business.dto;

import java.time.LocalDateTime;

import com.example.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarefasDTO {

	private String id; 
	private String nomeTarefa, descricao, emailUsuario;
	private LocalDateTime dataCriacao, dataAlteracao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dataEvento;
	private StatusNotificacaoEnum status;
}

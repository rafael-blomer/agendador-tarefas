package com.example.agendadortarefas.infrastructure.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("tarefa")
public class Tarefas {
	
	@Id
	private String id; 
	private String nomeTarefa, descricao, emailUsuario;
	private LocalDateTime dataCriacao, dataEvento, dataAlteracao;
	private StatusNotificacaoEnum status;
}

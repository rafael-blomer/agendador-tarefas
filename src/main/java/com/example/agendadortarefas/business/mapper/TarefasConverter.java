package com.example.agendadortarefas.business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.agendadortarefas.business.dto.TarefasDTO;
import com.example.agendadortarefas.infrastructure.entity.Tarefas;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

	@Mapping(source = "id", target = "id")
	Tarefas paraTarefaEntity (TarefasDTO dto);
	
	TarefasDTO paraTarefaDTO(Tarefas entity);
}

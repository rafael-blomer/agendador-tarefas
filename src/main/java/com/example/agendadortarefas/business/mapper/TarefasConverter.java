package com.example.agendadortarefas.business.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.agendadortarefas.business.dto.TarefasDTO;
import com.example.agendadortarefas.infrastructure.entity.Tarefas;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

	Tarefas paraTarefaEntity (TarefasDTO dto);
	
	TarefasDTO paraTarefaDTO(Tarefas entity);
	
	List<TarefasDTO> paraListTarefasDto(List<Tarefas> entities);

	List<Tarefas> paraListTarefasEntity(List<TarefasDTO> dtos);
}

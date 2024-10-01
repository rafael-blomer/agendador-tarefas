package com.example.agendadortarefas.business.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.agendadortarefas.business.dto.TarefasDTO;
import com.example.agendadortarefas.infrastructure.entity.Tarefas;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

	@Mapping(source = "id", target = "id")
	Tarefas paraTarefaEntity (TarefasDTO dto);
	
	TarefasDTO paraTarefaDTO(Tarefas entity);
	
	List<TarefasDTO> paraListTarefasDto(List<Tarefas> entities);

	List<Tarefas> paraListTarefasEntity(List<TarefasDTO> dtos);
}

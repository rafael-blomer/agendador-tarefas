package com.example.agendadortarefas.business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.agendadortarefas.business.dto.TarefasDTO;
import com.example.agendadortarefas.infrastructure.entity.Tarefas;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefasUpdateConverter {

	void updateTarefas(TarefasDTO dto, @MappingTarget Tarefas entity);
}

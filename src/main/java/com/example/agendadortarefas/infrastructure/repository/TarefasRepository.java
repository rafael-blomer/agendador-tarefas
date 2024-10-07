package com.example.agendadortarefas.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.agendadortarefas.infrastructure.entity.Tarefas;
import com.example.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;

@Repository
public interface TarefasRepository extends MongoRepository<Tarefas, String> {

	List<Tarefas> findByDataEventoBetweenAndStatus(LocalDateTime start, LocalDateTime end, StatusNotificacaoEnum status);
	List<Tarefas> findByEmailUsuario(String email);

}

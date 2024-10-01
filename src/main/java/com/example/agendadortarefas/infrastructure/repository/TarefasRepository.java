package com.example.agendadortarefas.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.agendadortarefas.infrastructure.entity.Tarefas;

@Repository
public interface TarefasRepository extends MongoRepository<Tarefas, String> {

	List<Tarefas> findByDataEventoBetween(LocalDateTime start, LocalDateTime end);
	List<Tarefas> findByEmailUsuario(String email);

}

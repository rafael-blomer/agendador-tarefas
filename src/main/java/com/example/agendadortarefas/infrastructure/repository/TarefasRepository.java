package com.example.agendadortarefas.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.agendadortarefas.infrastructure.entity.Tarefas;

@Repository
public interface TarefasRepository extends MongoRepository<Tarefas, String> {

}

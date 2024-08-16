package org.example.todo_back.repository;

import jakarta.persistence.Entity;
import org.example.todo_back.models.TodoEntity;
import org.example.todo_back.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    public List<TodoEntity> findAllByUsers(UserEntity userEntity );
}

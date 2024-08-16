package org.example.todo_back.services;

import org.example.todo_back.dto.todos.TodoGetDto;
import org.example.todo_back.dto.todos.TodoPostDto;
import org.example.todo_back.models.TodoEntity;
import org.example.todo_back.repository.TodoRepository;
import org.example.todo_back.utils.EtatTodos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService implements BasesServices<TodoGetDto, TodoPostDto, TodoEntity> {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserService userService;


    public List<TodoEntity> findAllTodoUser(Long idUsers) {
        return todoRepository.findAllByUsers(userService.findById(idUsers));
    }

    @Override
    public TodoGetDto findBYId(long id) {
        return entityToGet(todoRepository.getReferenceById(id));
    }

    @Override
    public List<TodoGetDto> findAll() {
        List<TodoGetDto> todoGetDtos = new ArrayList<>();
        List<TodoEntity> todoEntities = todoRepository.findAll();
        for (TodoEntity todo : todoEntities) {
            todoGetDtos.add(entityToGet(todo));
        }
        return todoGetDtos;
    }

    @Override
    public TodoGetDto save(TodoPostDto entity) {
        TodoEntity todoEntity = postToEntity(entity);
        todoEntity.setUsers(userService.findById(entity.getIdUsers()));
        return entityToGet(todoRepository.save(todoEntity));
    }

    @Override
    public TodoGetDto update(TodoPostDto entity, long id) {
        TodoEntity todo = todoRepository.getReferenceById(id);
        todo.setName(entity.getName());
        todo.setDescription(todo.getDescription());
        todo.setEtat(entity.getEtatTodos());
        return entityToGet(todoRepository.save(todo));
    }

    @Override
    public String deleteById(long id) {
        todoRepository.deleteById(id);
        return (todoRepository.getReferenceById(id) == null) ? "L'" + id + " à été supprimer" : "echec";
    }

    @Override
    public TodoGetDto entityToGet(TodoEntity entity) {
        TodoGetDto todoGetDto = new TodoGetDto();
        todoGetDto.setId(entity.getId());
        todoGetDto.setEtat(entity.getEtat());
        todoGetDto.setDescription(entity.getDescription());
        todoGetDto.setName(entity.getName());
        return todoGetDto;
    }

    @Override
    public TodoEntity postToEntity(TodoPostDto entity) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setName(entity.getName());
        todoEntity.setDescription(entity.getDescription());
        return todoEntity;
    }
}

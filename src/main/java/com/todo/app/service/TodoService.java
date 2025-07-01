package com.todo.app.service;

import com.todo.app.model.Todo;
import com.todo.app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepo;

    public Todo createTask(Todo todo){
        return todoRepo.save(todo);
    }

    public List<Todo> getAllTask(){
        return todoRepo.findAll();
    }

    public List<Todo> getTaskById(String id){
        return todoRepo.findAllById(id);
    }

    public Todo updateTaskById(String id, Todo updateTaskById){
        Todo existing = todoRepo.findById(id).orElseThrow(()-> new RuntimeException("Todo list is not found with this id"));
        existing.setTitle(updateTaskById.getTitle());
        existing.setDescription(updateTaskById.getDescription());
        existing.setStatus(updateTaskById.getStatus());
        return todoRepo.save(existing);
    }

    public void deleteTaskById(String id){
        todoRepo.deleteById(id);
    }

}

package com.todo.app.controller;

import com.todo.app.model.Todo;
import com.todo.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/todos")
    public Todo createtask(@RequestBody Todo todo){
        return todoService.createTask(todo);
    }

    @GetMapping("/todos")
    public List<Todo> getalltask(){
        return todoService.getAllTask();
    }

    @GetMapping("/todos/{id}")
    public List<Todo> gettaskbyid(@PathVariable String id){
        return  todoService.getTaskById(id);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updatetaskbyid(@PathVariable String id, @RequestBody Todo updatetaskbyid){
        Todo todo = todoService.updateTaskById(id,updatetaskbyid);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deletebyid(String id){
        todoService.deleteTaskById(id);
    }
}

package com.todo.Todo.rest;

import com.sun.xml.bind.v2.TODO;
import com.todo.Todo.model.Todo;
import com.todo.Todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin("http://localhost:4200") // Utilizar um dominio diferente com essa anotação
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping
    public Todo save(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @GetMapping("{id}")
    public Todo getId(@PathVariable Long id){
        return todoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        todoRepository.deleteById(id);
    }

    @PatchMapping("{id}/feito")
    public Todo maarkDone(@PathVariable Long id){
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setFeito(true);
                    todo.setDataConclucao(LocalDateTime.now());
                    todoRepository.save(todo);
                    return todo;
                }).orElseThrow(null);
    }



}

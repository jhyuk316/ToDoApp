package com.jhyuk316.todoapp.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.jhyuk316.todoapp.dto.ResponseDTO;
import com.jhyuk316.todoapp.dto.TodoDTO;
import com.jhyuk316.todoapp.model.TodoEntity;
import com.jhyuk316.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/test")
    public ResponseEntity<?> testTodo() {
        String str = service.testService();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }

    // HTTP POST를 이용하는 Create REST API 개발
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto) {
        try {
            String temporaryUserId = "temporary-user";

            TodoEntity entity = TodoDTO.toEntity(dto);

            entity.setId(null);

            entity.setUserId(temporaryUserId);

            List<TodoEntity> entities = service.create(entity);

            List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }


    // HTTP GET를 이용하는 Retrieve REST API 개발

    // HTTP UPDATE를 이용하는 Update REST API 개발

    // HTTP DELETE를 이용하는 Delete REST API 개발



}

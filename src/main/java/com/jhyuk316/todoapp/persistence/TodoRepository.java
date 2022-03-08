package com.jhyuk316.todoapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.jhyuk316.todoapp.model.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    // <T, ID> ID의 타입

    List<TodoEntity> findByUserId(String userId);
}

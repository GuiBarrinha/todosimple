package com.guilhermebarrinha.todosimple.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilhermebarrinha.todosimple.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}


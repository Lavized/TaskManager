package com.flex.taskmanager.repository;

import com.flex.taskmanager.domain.Task;
import com.flex.taskmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByUser(User user);

}

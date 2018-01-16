package com.flex.taskmanager.service;

import com.flex.taskmanager.domain.Task;
import com.flex.taskmanager.domain.User;
import com.flex.taskmanager.repository.TaskRepository;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTask(User user){
        return taskRepository.findByUser(user);
    }

}

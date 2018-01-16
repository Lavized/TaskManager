package com.flex.taskmanager.conrollers;

import com.flex.taskmanager.domain.Task;
import com.flex.taskmanager.service.TaskService;
import com.flex.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/addTask")
    public String taskForm(String email, Model model, HttpSession session){
        session.setAttribute("email",email);
        model.addAttribute("task",new Task());
        return "views/taskForm";
    }


    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()){
            return "views/taskForm";
        }
        String email = (String) session.getAttribute("email");
        taskService.addTask(task,userService.findUser(email));
        return "redirect:/users";
    }

}

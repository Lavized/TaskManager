package com.flex.taskmanager.conrollers;

import com.flex.taskmanager.domain.User;
import com.flex.taskmanager.service.TaskService;
import com.flex.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private TaskService taskService;

    @Autowired
    UserService userService;


    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {

        String email = principal.getName();
        User user = userService.findUser(email);

        model.addAttribute("tasks",taskService.findUserTask(user));

        return "views/profile";
    }

}

package com.flex.taskmanager;


import com.flex.taskmanager.domain.User;
import com.flex.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskmanagerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		User admin = new User("admin@mail.com","admin","admin");
		userService.createAdmin(admin);

	}
}

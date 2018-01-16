package com.flex.taskmanager;

import com.flex.taskmanager.domain.Task;
import com.flex.taskmanager.domain.User;
import com.flex.taskmanager.service.TaskService;
import com.flex.taskmanager.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.*;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskmanagerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@Before
	public void initDB() {
		{
			User user = new User("user@mail.com","user","123456");
			userService.createUser(user);
		}
		{
			User admin = new User("admin@mail.com","admin","123456");
			userService.createAdmin(admin);
		}


		Task userTask = new Task("03/01/2018","00:50","06:00",
				"You need to work today");

		User user = userService.findUser("user@mail.com");
		taskService.addTask(userTask,user);

	}


	@Test
	public void testUser(){
	    User user = userService.findUser("user@mail.com");
		assertThat(user).isNotNull();

        User admin = userService.findUser("admin@mail.com");
        assertThat(admin.getEmail()).isNotNull().isEqualTo("admin@mail.com");
	}

	@Test
    public void testTask(){
        User user = userService.findUser("user@mail.com");
        List<Task> tasks = taskService.findUserTask(user);
        assertThat(user).isNotNull();
    }

}





























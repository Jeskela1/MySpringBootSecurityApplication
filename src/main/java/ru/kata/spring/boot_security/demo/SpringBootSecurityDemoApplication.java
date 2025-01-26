package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.Service.UserServiceImpl;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class SpringBootSecurityDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	

//	Role r1 = new Role("ROLE_ADMIN");
//
//	Role r2 = new Role("ROLE_USER");
//
//	User user = new User("admin", "$2a$12$iKj6QGtC4vJYISm5vTpADemMdVAttbRV7sCSyfVkiS5EDNuBm5X66",
//			"admin@mail.ru", Stream.of(r1, r2).collect(Collectors.toList()));
//
//	Collection<Role> roleList = new ArrayList<>();
//
//
//
//	UserService userService =applicationContext.getBean(UserServiceImpl.class);
//	userService.saveUser(user);

}
}

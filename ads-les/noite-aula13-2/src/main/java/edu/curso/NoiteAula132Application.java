package edu.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class NoiteAula132Application {

	public static void main(String[] args) {
		PasswordEncoder passEncode = new BCryptPasswordEncoder();
		String user1 = passEncode.encode("user1");
		String manager1 = passEncode.encode("manager1");
		System.out.println("User1: " + user1);
		System.out.println("Manager1: " + manager1);
		SpringApplication.run(NoiteAula132Application.class, args);
	}

}

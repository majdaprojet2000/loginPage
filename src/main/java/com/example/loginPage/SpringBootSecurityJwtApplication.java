package com.example.loginPage;


import com.example.loginPage.entities.ERole;
import com.example.loginPage.entities.Role;
import com.example.loginPage.entities.User;
import com.example.loginPage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityJwtApplication implements CommandLineRunner {

	public static void main(String[] args) {
    SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		Role adminRole=new Role(ERole.ROLE_DOCTOR);
		User admin=new User("admin", passwordEncoder().encode("adminPW"));
		admin.addRole(adminRole);

		Role nurseRole=new Role(ERole.ROLE_NURSE);
		User nurse=new User("nurse",passwordEncoder().encode("nursePW"));
        nurse.addRole(nurseRole);

		userRepository.save(admin);
		userRepository.save(nurse);
	}
}



package io.namya.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	
	@Value("${app.message}")
	private String message;
	public String greet;
	
	@Profile("dev")
	@Bean
	public void Greet() {
		greet="Hello dev";
	}
	@Profile("test")
	@Bean
	public void GreetHola() {
		greet="Hello test";
	}
	
	
	@GetMapping("/hello")
	private String hello(){
		System.out.println(message);
		return greet;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

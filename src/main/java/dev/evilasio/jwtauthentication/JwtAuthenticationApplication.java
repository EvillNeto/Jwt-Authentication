package dev.evilasio.jwtauthentication;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.evilasio.jwtauthentication.seeder.DefaultSeeder;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class JwtAuthenticationApplication {

	private final DefaultSeeder defaultSeeder;

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationApplication.class, args);
	}

	@PostConstruct
	public void onStart(){
		defaultSeeder.seedAdmin();
	}
}

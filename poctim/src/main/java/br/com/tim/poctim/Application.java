package br.com.tim.poctim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@PropertySource(value = "classpath:application.properties")
public class Application{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class);
	}
}
package dev.devaz.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "dev.devaz.schedule.*")
@ComponentScan(basePackages = "dev.devaz.schedule.*")
@EnableJpaRepositories(basePackages = { "dev.devaz.schedule.*" })
@EntityScan(basePackages = { "dev.devaz.schedule.*" })
public class ScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

}
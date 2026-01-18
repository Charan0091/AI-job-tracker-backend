package com.aijobtracker.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class
        }
)
public class AiJobTrackerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiJobTrackerBackendApplication.class, args);
	}

}

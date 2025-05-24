package com.txt1stparkuor.buoi8;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class Buoi8Application {

	public static void main(String[] args) {
		Environment env = SpringApplication.run(Buoi8Application.class, args).getEnvironment();
		String appName = env.getProperty("spring.application.name");
		if (appName != null) {
			appName = appName.toUpperCase();
		}
		String port = env.getProperty("server.port");
		log.info("-------------------------START " + appName
				+ " Application------------------------------");
		log.info("   Application         : " + appName);
		log.info("   Url swagger-ui      : http://localhost:" + port + "/swagger-ui/index.html");
		log.info("-------------------------START SUCCESS " + appName
				+ " Application------------------------------");
	}

}

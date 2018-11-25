package com.cybrilla.cybrilla;

import java.util.Iterator;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class CybrillaApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(CybrillaApplication.class, args);

		for (String string : applicationContext.getBeanDefinitionNames()) {
			System.out.println(string);
		}

	}
}

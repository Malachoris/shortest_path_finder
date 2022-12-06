package com.assignment.nl22w;

import com.assignment.nl22w.game.impl.GameImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(GameApplication.class, args);
		try {
			GameImpl runner = context.getBean(GameImpl.class);
			Resource resource = new DefaultResourceLoader().getResource("classpath:map1.txt");
			int stepsCount = runner.escapeFromTheWoods(resource);
			System.out.println(stepsCount);
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
}

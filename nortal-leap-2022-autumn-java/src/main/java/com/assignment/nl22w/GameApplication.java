package com.assignment.nl22w;

import com.assignment.nl22w.game.Game;
import com.assignment.nl22w.game.impl.GameImpl;
import com.assignment.nl22w.game.solution.TextFileReader;
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
			Resource resource = new DefaultResourceLoader().getResource("classpath:map1.txt");
			GameImpl runner = context.getBean(GameImpl.class);
			runner.escapeFromTheWoods(resource);
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
}

package ru.poldjoke.demo.jokebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAspectJAutoProxy
@EnableScheduling
@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
public class JokeBotApplication {
	/*
	POST /jokes - body: id, text, date upload, date update
	GET /jokes - выдать все шутки
	GET /jokes/id выдать шутка с этим id
	PUT /jokes/id
	DELETE /jokes/id
	 */

	public static void main(String[] args) {
		SpringApplication.run(JokeBotApplication.class, args);
	}

}

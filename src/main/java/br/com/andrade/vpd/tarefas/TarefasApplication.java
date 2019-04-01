package br.com.andrade.vpd.tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);
	}

}

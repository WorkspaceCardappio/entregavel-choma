package br.com.cardappio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CardappioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardappioApplication.class, args);
	}

}

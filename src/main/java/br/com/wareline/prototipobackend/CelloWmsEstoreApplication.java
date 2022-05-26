package br.com.wareline.prototipobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"br.com.wareline.prototipobackend"})
public class CelloWmsEstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CelloWmsEstoreApplication.class, args);
	}

}

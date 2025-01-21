package test.infobip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InfobipApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfobipApplication.class, args);
	}

}

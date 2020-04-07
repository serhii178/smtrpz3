package labulka.mine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MineApplication.class, args);
	}

}

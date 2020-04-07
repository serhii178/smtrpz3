package smtrpz.mineappgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MineAppGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MineAppGatewayApplication.class, args);
	}

}

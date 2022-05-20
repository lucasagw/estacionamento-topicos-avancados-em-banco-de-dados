package app.ucsal.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class UcsalApiGatewayApplication {

	 public static void main(String[] args) {
		SpringApplication.run(UcsalApiGatewayApplication.class, args);
	}
}

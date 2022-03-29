package app.ucsal.apiauthorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class UcsalApiAuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcsalApiAuthorizationServerApplication.class, args);
	}
}

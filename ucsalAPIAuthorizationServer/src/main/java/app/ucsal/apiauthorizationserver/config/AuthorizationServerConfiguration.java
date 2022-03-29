package app.ucsal.apiauthorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
public class AuthorizationServerConfiguration extends WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer {

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return(super.authenticationManagerBean());
	}
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	PasswordEncoder passwordEnconder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("permitAll()").tokenKeyAccess("permitAll()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("estacionamentoApp").secret(passwordEnconder.encode("85478aa1-8fae-46cd-8da0-dacd7ec9f561")).scopes("READ","WRITE").authorizedGrantTypes("password","authorization_code","refresh_token");
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}
	
}

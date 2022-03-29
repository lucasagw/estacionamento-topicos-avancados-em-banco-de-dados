package app.ucsal.apiauthorizationserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {

	PasswordEncoder passwordEnconder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("!ucsal#").password(passwordEnconder.encode("daa84c89-2e75-450c-9dda-c1113050ab99"))
		                             .roles("ADMIN","USER","MANAGER").authorities("CAN_READ","CAN_WRITE","CAN_DELETE").and()
		                             .withUser("5571999999999-73432587-e233-4dbd-bb97-4a043518097e").password(passwordEnconder.encode("daa83c88-2e76-447c-9dda-c1103049ab96"))
		                             .roles("USER").authorities("CAN_READ","CAN_WRITE").and()
								     .withUser("+5599#5392b2b5ef383471557cd983f0667e4ae2a4df62").password(passwordEnconder.encode("85eab1c933a7da47960be6b9e2b0508515be12ff"))
								     .roles("USER").authorities("CAN_READ","CAN_WRITE").and()
								     .withUser("+5571#7c3852e2cb771644d71bcd6313de2b50bdb8c2a2").password(passwordEnconder.encode("32f86f9bf66eb331eba6c57b45d48335f8b5db07"))
								     .roles("USER").authorities("CAN_READ","CAN_WRITE");
	}
	
}

package net.mofed.reportracking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import net.mofed.reportracking.app.security.SpringSecurityAuditorAware;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")

public class TodoManagementSpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(TodoManagementSpringBoot2Application.class, args);
	}
	
	
	
	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
	    StrictHttpFirewall firewall = new StrictHttpFirewall();
	    firewall.setAllowUrlEncodedSlash(true);  
	    firewall.setAllowSemicolon(true);
	    return firewall;
	}
	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}
}

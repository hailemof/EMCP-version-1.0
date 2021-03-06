package net.mofed.reportracking.app.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends  WebSecurityConfigurerAdapter{
	String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
        .antMatchers(resources).permitAll()  
        .antMatchers("/login").permitAll() 
     
         
        .antMatchers("/organizations").access("hasRole('ADMIN')")
        .antMatchers("/userlist").access("hasRole('SYSADMIN')")
        
        .antMatchers("/signup").access("hasRole('SYSADMIN')")
        .antMatchers("/audittransactionlists").access("hasRole('AUDIT')")
        .antMatchers("/budgettransactionlists").access("hasRole('BUDGET')")
        .antMatchers("/propertytransactionlists").access("hasRole('PROPERTY')")
        .antMatchers("/cashtransactionlists").access("hasRole('CASH')")
        .antMatchers("/accounttransactionlists").access("hasRole('ACCOUNT')")
        .antMatchers("/purchasetransactionlists").access("hasRole('PURCHASE')")
        
        .antMatchers("/toaccount").access("hasRole('USER')")
        .antMatchers("/topurchase").access("hasRole('USER')")
        .antMatchers("/tobudget").access("hasRole('USER')")
        .antMatchers("/toaudit").access("hasRole('USER')")
        .antMatchers("/toproperty").access("hasRole('USER')")
        .antMatchers("/tocash").access("hasRole('USER')")
        
        .anyRequest().authenticated()
        .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .defaultSuccessUrl("/")
            
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .csrf().disable()
        .logout()
        .and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403");
    }
	BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
    
    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
    	//Especificar el encargado del login y encriptacion del password
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
      
    
}

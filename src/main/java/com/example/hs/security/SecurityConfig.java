package com.example.hs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((authorizeHttpRequests) ->
             authorizeHttpRequests
                     .requestMatchers(HttpMethod.GET).permitAll()
			)
			.httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();
		
	}
	
	@Bean
	InMemoryUserDetailsManager users() {
		UserDetails admin = User.builder()
				.username("admin")
				.password("admin")
				.roles("ADMIN")
				.build();
		
		 UserDetails user = User.builder()
                 .username("user")
                 .password("password")
                 .roles("USER")
                 .build();
		return new InMemoryUserDetailsManager(admin, user);
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
		try {
			return authenticationConfiguration.getAuthenticationManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.salesianostriana.dam.clinicamedinalejeunevictor.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}

	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

		return authBuilder.authenticationProvider(daoAuthenticationProvider()).build();

	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz
				.requestMatchers("/css/**", "/js/**", "/audio/**", "img/**", "/error/**", "/h2-console/**").permitAll()

				.requestMatchers("/cliente/**").hasAnyRole("CLIENTE")

				.requestMatchers("/doctor/**").hasAnyRole("DOCTOR")

				.requestMatchers("/admin/**").hasAnyRole("ADMIN")

				.anyRequest().permitAll())

				.formLogin((loginz) -> loginz.loginPage("/login").defaultSuccessUrl("/").permitAll())

				.logout((logoutz) -> logoutz.logoutUrl("/logout").logoutSuccessUrl("/").permitAll())

				.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/error"));

		http.csrf(csrfz -> csrfz.disable());
		http.headers(headersz -> headersz.frameOptions(frameOptionsz -> frameOptionsz.disable()));

		return http.build();
	}
}

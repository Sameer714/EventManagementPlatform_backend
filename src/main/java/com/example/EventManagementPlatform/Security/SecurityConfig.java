package com.example.EventManagementPlatform.Security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import jakarta.servlet.Filter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	    @Autowired
	    private JwtAuthenticationEntryPt point;

	    @Autowired
	    private JwtAuthenticationFilter filter;

	    @SuppressWarnings("removal")
		@Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .cors().and()  // Enable CORS
	            .csrf(csrf -> csrf.disable())  // Disable CSRF
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers(HttpMethod.POST, "/createuser").permitAll() // Allow signup
	                .requestMatchers(HttpMethod.POST, "/v1/api/otp/send").permitAll() // Allow OTP requests
	                .requestMatchers(HttpMethod.GET, "/getallevents").permitAll() 
	                .requestMatchers("/auth/login").permitAll() // Allow login
	                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Allow preflight requests
	                .anyRequest().authenticated()
	            )
	            .exceptionHandling(ex -> ex.authenticationEntryPoint((AuthenticationEntryPoint) point))
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	        http.addFilterBefore((Filter) filter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }

	    @Bean
	    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowedOrigins(List.of("http://localhost:4200")); // Allow frontend
	        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow methods
	        config.setAllowedHeaders(List.of("*")); // Allow all headers
	        config.setAllowCredentials(true); // Allow credentials
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
	}

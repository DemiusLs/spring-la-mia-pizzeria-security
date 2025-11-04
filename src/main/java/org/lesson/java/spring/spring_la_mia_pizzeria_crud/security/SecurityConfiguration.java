package org.lesson.java.spring.spring_la_mia_pizzeria_crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(requests ->requests
        .requestMatchers("/pizzas/create" , "/pizza/edit/**").hasAuthority("ADMIN")
        .requestMatchers(HttpMethod.POST , "/pizza/**").hasAuthority("ADMIN")       
        .requestMatchers("/ingredients" , "/pizza/edit/**").hasAuthority("ADMIN")
        .requestMatchers("/pizzas/index" , "/pizza/**").hasAnyAuthority("USER", "ADMIN")
        .requestMatchers("/**").permitAll()
        ).formLogin(Customizer.withDefaults())
        .logout(logout -> logout.logoutSuccessUrl("/login?logout"));
        // .cors(cors -> cors.disable())
        // .csrf(csrf -> csrf.disable());
    
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    DatabaseUserDetailsService userDetailsService(){
        return new DatabaseUserDetailsService();
    }
    

    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}

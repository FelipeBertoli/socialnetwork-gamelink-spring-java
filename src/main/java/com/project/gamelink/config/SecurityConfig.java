package com.project.gamelink.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.service.invoker.RequestAttributeArgumentResolver;

import com.amazonaws.services.identitymanagement.model.UserDetail;
import com.project.gamelink.model.User;
import com.project.gamelink.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    UserRepository userRepository; 

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((requests) -> requests
                                    .anyRequest().authenticated()
                                    ).formLogin(Customizer.withDefaults())
                                    .build();

                    
    }
    // @Bean
    // public UserDetails loadUser(String email) {
    //     User user = userRepository.findByEmail(email);
    //     if (user == null) {
    //         throw new UsernameNotFoundException("Usuário não encontrado");
    //     }
        
    //     // Construa e retorne uma instância de UserDetails com as informações do usuário
    //     return org.springframework.security.core.userdetails.User.builder()
    //         .username(user.getEmail())
    //         .password(user.getPassword())
    //         .roles("USER")
    //         .build();
    // }
    
}

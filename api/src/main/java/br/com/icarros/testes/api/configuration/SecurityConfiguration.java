package br.com.icarros.testes.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public static String[] WHITELIST = {"/swagger-ui/**"};

    public static String BASE_URL = "/api/v1/";

    public static String ALL_PATH = "**";

    public static String ROLE_USER = "USER";

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;


    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(BASE_URL + ALL_PATH).hasRole(ROLE_USER);
                    auth.requestMatchers(WHITELIST).permitAll()
                            .anyRequest().authenticated();
                })
                .httpBasic()
                .and().build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userDetails = User.withUsername(username)
                .password(passwordEncoder().encode(password))
                .roles(ROLE_USER)
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
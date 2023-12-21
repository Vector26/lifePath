package com.lifepath.configs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jwt.secret}")
    private String secret;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter(secret); // Replace with your actual secret key
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Set session as stateless
                .and()
                .authorizeRequests()
                .antMatchers("/auth/register", "/auth/login").permitAll() // Permit these without authentication
                .anyRequest().authenticated() // All other requests need to be authenticated
                .and()
                .addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);// Add your JWT Token Filter here
                // Additional configurations (like formLogin or httpBasic) if necessary
    }
}
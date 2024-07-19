package com.lvr.Build.a.bear.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  SecurityFilterChain configure(HttpSecurity http) throws Exception {
    // dit authentication (basic versie van spring security)
    http.httpBasic(Customizer.withDefaults());
    // authorization
    http.authorizeHttpRequests(c -> c.anyRequest().permitAll());

    return http.build();
  }

  @Bean
  UserDetailsService userDetailsService() {
    UserDetails user = User.withUsername("laila").password("12345").authorities("read").build();
    return new InMemoryUserDetailsManager(user);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}

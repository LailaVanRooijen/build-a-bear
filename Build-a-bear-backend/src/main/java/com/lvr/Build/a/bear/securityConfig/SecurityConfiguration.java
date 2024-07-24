package com.lvr.Build.a.bear.securityConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/api/v1/auth/**")
        .permitAll()
        .requestMatchers(
            HttpMethod.GET,
            "/api/v1/bears",
            "/api/v1/colors",
            "/api/v1/fur-patterns",
            "/api/v1/fur-types",
            "/api/v1/voices",
            "/api/v1/outfits")
        .permitAll()
        .requestMatchers(
            HttpMethod.POST,
            "/api/v1/bears",
            "/api/v1/colors",
            "/api/v1/fur-patterns",
            "/api/v1/fur-types",
            "/api/v1/voices",
            "/api/v1/outfits")
        .authenticated()
        .requestMatchers(
            HttpMethod.PATCH,
            "/api/v1/bears",
            "/api/v1/colors",
            "/api/v1/fur-patterns",
            "/api/v1/fur-types",
            "/api/v1/voices",
            "/api/v1/outfits")
        .authenticated()
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}

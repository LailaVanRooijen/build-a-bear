package com.lvr.Build.a.bear.securityConfig;

import com.lvr.Build.a.bear.user.Role;
import com.lvr.Build.a.bear.user.User;
import com.lvr.Build.a.bear.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAdmin implements CommandLineRunner {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @org.springframework.beans.factory.annotation.Value("${security.username}")
  private String adminUsername;

  @Value("${security.password}")
  private String adminPassword;

  @Override
  public void run(String... args) throws Exception {
    if (userRepository.findByEmail("admin").orElse(null) == null) {
      User admin =
          User.builder()
              .firstName("admin")
              .lastName("admin")
              .email(adminUsername)
              .password(passwordEncoder.encode(adminPassword))
              .role(Role.ADMIN)
              .build();
      userRepository.save(admin);
    }
  }
}

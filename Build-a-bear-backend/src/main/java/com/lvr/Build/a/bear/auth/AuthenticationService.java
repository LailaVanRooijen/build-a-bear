package com.lvr.Build.a.bear.auth;

public interface AuthenticationService {
  JwtAuthenticationResponse register(registerDto request);

  JwtAuthenticationResponse login(loginDto request);
}

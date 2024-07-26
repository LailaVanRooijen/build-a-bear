package com.lvr.Build.a.bear.auth;

public interface AuthenticationService {
  JwtAuthenticationResponse signup(registerDto request);

  JwtAuthenticationResponse signin(loginDto request);
}

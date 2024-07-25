package com.lvr.Build.a.bear.auth;

public interface AuthenticationService {
  JwtAuthenticationResponse signup(SignUpRequest request);

  JwtAuthenticationResponse signin(SigninRequest request);
}

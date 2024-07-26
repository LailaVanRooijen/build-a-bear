package com.lvr.Build.a.bear.auth;

import static com.lvr.Build.a.bear.appconfiguration.Routes.AUTH;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AUTH)
@CrossOrigin(origins = {"http://localhost:5173"})
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<JwtAuthenticationResponse> register(@RequestBody registerDto request) {
    return ResponseEntity.ok(authenticationService.signup(request));
  }

  @PostMapping("/login")
  public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody loginDto request) {
    return ResponseEntity.ok(authenticationService.signin(request));
  }
}

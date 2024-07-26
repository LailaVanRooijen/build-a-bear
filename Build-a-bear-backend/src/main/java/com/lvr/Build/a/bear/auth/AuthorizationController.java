package com.lvr.Build.a.bear.auth;

import static com.lvr.Build.a.bear.appconfiguration.Routes.AUTH;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AUTH)
@CrossOrigin(origins = {"http://localhost:5173"})
@RequiredArgsConstructor
public class AuthorizationController {
  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Here is your resource");
  }
}

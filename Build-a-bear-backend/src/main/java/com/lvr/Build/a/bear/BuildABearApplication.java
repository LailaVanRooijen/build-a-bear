package com.lvr.Build.a.bear;

import com.lvr.Build.a.bear.appconfiguration.CustomBanner;
import com.lvr.Build.a.bear.bear.Bear;
import com.lvr.Build.a.bear.bear.BearRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class BuildABearApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(BuildABearApplication.class);
    app.setBanner(new CustomBanner());
    app.run(args);
  }
}

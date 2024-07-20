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
public class BuildABearApplication implements CommandLineRunner {
  BearRepository bearRepository;

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(BuildABearApplication.class);
    app.setBanner(new CustomBanner());
    app.run(args);
  }

  @Override
  public void run(String... args) throws Exception {
    bearRepository.save(new Bear("Jannie"));
    bearRepository.save(new Bear("Klaas"));
    bearRepository.save(new Bear("Anja"));
  }
}

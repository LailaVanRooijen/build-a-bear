package com.lvr.Build.a.bear.bear;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Bear {
  @Id @GeneratedValue private UUID id;

  @Setter private String name;

  public Bear(String name) {
    this.name = name;
  }
}

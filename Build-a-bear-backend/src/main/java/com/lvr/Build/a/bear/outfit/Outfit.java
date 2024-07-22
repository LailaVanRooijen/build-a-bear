package com.lvr.Build.a.bear.outfit;

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
public class Outfit {
  @Id @GeneratedValue UUID id;

  @Setter private String name;
  @Setter private String head;
  @Setter private String chest;
  @Setter private String feet;

  public Outfit(String name, String head, String chest, String feet) {
    this.name = name;
    this.head = head;
    this.chest = chest;
    this.feet = feet;
  }
}

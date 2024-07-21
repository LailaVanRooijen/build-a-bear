package com.lvr.Build.a.bear.bearcolor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.*;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class BearColor {
  @Id @GeneratedValue private UUID id;

  @Setter private String color;

  public BearColor(String color) {
    this.color = color;
  }
}

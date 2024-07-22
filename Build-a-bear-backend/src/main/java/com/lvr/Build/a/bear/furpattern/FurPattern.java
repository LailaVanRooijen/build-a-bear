package com.lvr.Build.a.bear.furpattern;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class FurPattern {
  @Id @GeneratedValue private UUID id;

  @Setter private String furPattern;

  public FurPattern(String furPattern) {
    this.furPattern = furPattern;
  }
}

package com.lvr.Build.a.bear.furtype;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class FurType {
  @Id @GeneratedValue UUID id;

  @Setter private String furType;

  public FurType(String furType) {
    this.furType = furType;
  }
}

package com.lvr.Build.a.bear.voice;

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
public class Voice {
  @Id @GeneratedValue private UUID id;

  @Setter private String voice;

  public Voice(String voice) {
    this.voice = voice;
  }
}

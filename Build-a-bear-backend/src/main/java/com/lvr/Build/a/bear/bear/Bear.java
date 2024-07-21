package com.lvr.Build.a.bear.bear;

import com.lvr.Build.a.bear.bearcolor.BearColor;
import com.lvr.Build.a.bear.outfit.Outfit;
import jakarta.persistence.*;

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

  @ManyToOne
  @JoinColumn(name = "color_id")
  @Setter
  private BearColor color;

  @ManyToOne
  @JoinColumn(name = "outfit_id")
  @Setter
  private Outfit outfit;

  public Bear(String name, BearColor color, Outfit outfit) {
    this.name = name;
    this.color = color;
    this.outfit = outfit;
  }
}

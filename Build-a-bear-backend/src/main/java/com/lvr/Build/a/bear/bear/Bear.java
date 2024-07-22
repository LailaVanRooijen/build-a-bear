package com.lvr.Build.a.bear.bear;

import com.lvr.Build.a.bear.bearcolor.BearColor;
import com.lvr.Build.a.bear.furpattern.FurPattern;
import com.lvr.Build.a.bear.furtype.FurType;
import com.lvr.Build.a.bear.outfit.Outfit;
import com.lvr.Build.a.bear.voice.Voice;
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

  @ManyToOne
  @JoinColumn(name = "fur_pattern_id")
  @Setter
  private FurPattern furPattern;

  @ManyToOne
  @JoinColumn(name = "fur_type_id")
  @Setter
  private FurType furType;

  @ManyToOne
  @JoinColumn(name = "voice_id")
  @Setter
  private Voice voice;

  public Bear(
      String name,
      BearColor color,
      Outfit outfit,
      FurPattern furPattern,
      FurType furType,
      Voice voice) {
    this.name = name;
    this.color = color;
    this.outfit = outfit;
    this.furPattern = furPattern;
    this.furType = furType;
    this.voice = voice;
  }
}

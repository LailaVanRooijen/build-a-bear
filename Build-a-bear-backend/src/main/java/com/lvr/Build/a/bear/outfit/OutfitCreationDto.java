package com.lvr.Build.a.bear.outfit;

public record OutfitCreationDto(String name, String head, String chest, String feet) {

  public Outfit toOutfit() {
    return new Outfit(this.name, this.head, this.chest, this.feet);
  }
}

package com.lvr.Build.a.bear.bear;

import com.lvr.Build.a.bear.bearcolor.ColorRepository;
import com.lvr.Build.a.bear.outfit.OutfitRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;

public record BearCreationDto(String name, UUID color, UUID outfit) {
  public Bear toBear(ColorRepository colorRepository, OutfitRepository outfitRepository) {
    Bear bear = new Bear();

    if (this.name != null) bear.setName(this.name);
    if (this.color != null) {
      bear.setColor(colorRepository.findById(this.color).orElseThrow(EntityNotFoundException::new));
    }
    if (this.outfit != null) {
      bear.setOutfit(
          outfitRepository.findById(this.outfit).orElseThrow(EntityNotFoundException::new));
    }
    return bear;
  }
}

package com.lvr.Build.a.bear.bear;

import java.util.UUID;

public record GetBearDto(
    UUID id,
    String name,
    String color,
    String outfit,
    String head,
    String chest,
    String feet,
    String furPattern,
    String furType,
    String voice) {

  public static GetBearDto convertToDto(Bear bear) {
    return new GetBearDto(
        bear.getId(),
        bear.getName(),
        bear.getColor().getColor(),
        bear.getOutfit().getName(),
        bear.getOutfit().getHead(),
        bear.getOutfit().getChest(),
        bear.getOutfit().getFeet(),
        bear.getFurPattern().getFurPattern(),
        bear.getFurType().getFurType(),
        bear.getVoice().getVoice());
  }
}

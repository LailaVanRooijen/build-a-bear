package com.lvr.Build.a.bear.bear;

import com.lvr.Build.a.bear.bearcolor.ColorService;
import com.lvr.Build.a.bear.furpattern.FurPatternService;
import com.lvr.Build.a.bear.furtype.FurTypeService;
import com.lvr.Build.a.bear.outfit.OutfitService;
import com.lvr.Build.a.bear.voice.VoiceService;

public record BearCreationDto(
    String name, String color, String voice, String furType, String furPattern, String outfit) {
  public Bear toBear(
      ColorService colorService,
      VoiceService voiceService,
      FurTypeService furTypeService,
      FurPatternService furPatternService,
      OutfitService outfitService) {
    Bear bear = new Bear();
    if (this.name != null) bear.setName(this.name);
    if (this.color != null) {
      bear.setColor(colorService.getByColor(this.color));
    }
    if (this.voice != null) {
      bear.setVoice(voiceService.getByVoice(this.voice));
    }
    if (this.furType != null) {
      bear.setFurType(furTypeService.getByFurType(this.furType));
    }
    if (this.furPattern != null) {
      bear.setFurPattern(furPatternService.getByFurPattern(this.furPattern));
    }
    if (this.outfit != null) {
      bear.setOutfit(outfitService.getByName(this.outfit));
    }
    return bear;
  }
}

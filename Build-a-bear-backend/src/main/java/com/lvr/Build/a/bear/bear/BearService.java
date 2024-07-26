package com.lvr.Build.a.bear.bear;

import com.lvr.Build.a.bear.bearcolor.BearColor;
import com.lvr.Build.a.bear.bearcolor.ColorRepository;
import com.lvr.Build.a.bear.bearcolor.ColorService;
import com.lvr.Build.a.bear.furpattern.FurPattern;
import com.lvr.Build.a.bear.furpattern.FurPatternService;
import com.lvr.Build.a.bear.furtype.FurType;
import com.lvr.Build.a.bear.furtype.FurTypeService;
import com.lvr.Build.a.bear.outfit.Outfit;
import com.lvr.Build.a.bear.outfit.OutfitRepository;
import com.lvr.Build.a.bear.outfit.OutfitService;
import com.lvr.Build.a.bear.specification.BearSpecification;
import com.lvr.Build.a.bear.voice.Voice;
import com.lvr.Build.a.bear.voice.VoiceService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BearService {
  private final BearRepository bearRepository;
  private final ColorRepository colorRepository;
  private final OutfitRepository outfitRepository;
  private final ColorService colorService;
  private final FurTypeService furTypeService;
  private final FurPatternService furPatternService;
  private final VoiceService voiceService;
  private final OutfitService outfitService;

  public List<GetBearDto> getAll(
      List<String> colors,
      List<String> furTypes,
      List<String> furPatterns,
      List<String> voices,
      List<String> outfits) {
    Specification<Bear> specification = Specification.where(null);

    if (colors != null && !colors.isEmpty()) {
      List<BearColor> colorList =
          colors.stream().map(colorService::getByColor).filter(Objects::nonNull).toList();
      for (BearColor color : colorList) {
        specification = specification.or(BearSpecification.hasColor(color));
      }
    }

    if (furTypes != null && !furTypes.isEmpty()) {
      List<FurType> furTypeList =
          furTypes.stream().map(furTypeService::getByFurType).filter(Objects::nonNull).toList();
      for (FurType furType : furTypeList) {
        specification = specification.or(BearSpecification.hasFurType(furType));
      }
    }

    if (furPatterns != null && !furPatterns.isEmpty()) {
      List<FurPattern> furPatternList =
          furPatterns.stream()
              .map(furPatternService::getByFurPattern)
              .filter(Objects::nonNull)
              .toList();
      for (FurPattern furPattern : furPatternList) {
        specification = specification.or(BearSpecification.hasFurPattern(furPattern));
      }
    }

    if (voices != null && !voices.isEmpty()) {
      List<Voice> voiceList =
          voices.stream().map(voiceService::getByVoice).filter(Objects::nonNull).toList();
      for (Voice voice : voiceList) {
        specification = specification.or(BearSpecification.hasVoice(voice));
      }
    }

    if (outfits != null && !outfits.isEmpty()) {
      List<Outfit> outfitsList =
          outfits.stream().map(outfitService::getByName).filter(Objects::nonNull).toList();
      for (Outfit outfit : outfitsList) {
        specification = specification.or(BearSpecification.hasOutfit(outfit));
      }
    }

    List<Bear> bears = bearRepository.findAll(specification);
    return bears.stream().map(GetBearDto::convertToDto).toList();
  }

  public GetBearDto getById(UUID id) {
    Bear bear = bearRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    return GetBearDto.convertToDto(bear);
  }

  public Bear save(BearCreationDto dto) {
    Bear bear =
        dto.toBear(colorService, voiceService, furTypeService, furPatternService, outfitService);
    bearRepository.save(bear);
    return bear;
  }

  public Bear update(UUID id, Bear patch) {
    Bear patchedBear = bearRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    if (patch.getName() != null) patchedBear.setName(patch.getName());
    bearRepository.save(patchedBear);
    return patchedBear;
  }

  public void delete(UUID id) {
    bearRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    bearRepository.deleteById(id);
  }
}

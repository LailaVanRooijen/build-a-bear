package com.lvr.Build.a.bear.bear;

import com.lvr.Build.a.bear.bearcolor.BearColor;
import com.lvr.Build.a.bear.furpattern.FurPattern;
import com.lvr.Build.a.bear.furtype.FurType;
import com.lvr.Build.a.bear.outfit.Outfit;
import com.lvr.Build.a.bear.voice.Voice;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class BearSpecification {

  public static Specification<Bear> hasColors(List<BearColor> colors) {
    return (root, query, criteriaBuilder) -> {
      Join<Bear, BearColor> colorJoin = root.join("color");
      CriteriaBuilder.In<BearColor> inClause = criteriaBuilder.in(colorJoin);
      for (BearColor color : colors) {
        inClause.value(color);
      }
      return inClause;
    };
  }

  public static Specification<Bear> hasFurTypes(List<FurType> furTypes) {
    return (root, query, criteriaBuilder) -> {
      Join<Bear, FurType> furTypeJoin = root.join("furType");
      CriteriaBuilder.In<FurType> inClause = criteriaBuilder.in(furTypeJoin);
      for (FurType furType : furTypes) {
        inClause.value(furType);
      }
      return inClause;
    };
  }

  public static Specification<Bear> hasFurPatterns(List<FurPattern> furPatterns) {
    return (root, query, criteriaBuilder) -> {
      Join<Bear, FurPattern> furPatternJoin = root.join("furPattern");
      CriteriaBuilder.In<FurPattern> inClause = criteriaBuilder.in(furPatternJoin);
      for (FurPattern furPattern : furPatterns) {
        inClause.value(furPattern);
      }
      return inClause;
    };
  }

  public static Specification<Bear> hasVoices(List<Voice> voices) {
    return (root, query, criteriaBuilder) -> {
      Join<Bear, Voice> voiceJoin = root.join("voice");
      CriteriaBuilder.In<Voice> inClause = criteriaBuilder.in(voiceJoin);
      for (Voice voice : voices) {
        inClause.value(voice);
      }
      return inClause;
    };
  }

  public static Specification<Bear> hasOutfits(List<Outfit> outfits) {
    return (root, query, criteriaBuilder) -> {
      Join<Bear, Outfit> outfitJoin = root.join("outfit");
      CriteriaBuilder.In<Outfit> inClause = criteriaBuilder.in(outfitJoin);
      for (Outfit outfit : outfits) {
        inClause.value(outfit);
      }
      return inClause;
    };
  }
}

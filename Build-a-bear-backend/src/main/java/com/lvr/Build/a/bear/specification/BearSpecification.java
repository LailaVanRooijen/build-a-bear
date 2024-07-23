package com.lvr.Build.a.bear.specification;

import com.lvr.Build.a.bear.bear.Bear;
import com.lvr.Build.a.bear.bearcolor.BearColor;
import com.lvr.Build.a.bear.furpattern.FurPattern;
import com.lvr.Build.a.bear.furtype.FurType;
import com.lvr.Build.a.bear.outfit.Outfit;
import com.lvr.Build.a.bear.voice.Voice;
import org.springframework.data.jpa.domain.Specification;

public class BearSpecification {
  public static Specification<Bear> hasColor(BearColor color) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("color"), color);
  }

  public static Specification<Bear> hasFurPattern(FurPattern furPattern) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get("furPattern"), furPattern);
  }

  public static Specification<Bear> hasFurType(FurType furType) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("furType"), furType);
  }

  public static Specification<Bear> hasVoice(Voice voice) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("voice"), voice);
  }

  public static Specification<Bear> hasOutfit(Outfit outfit) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("outfit"), outfit);
  }
}

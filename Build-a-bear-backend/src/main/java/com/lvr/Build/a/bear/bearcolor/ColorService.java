package com.lvr.Build.a.bear.bearcolor;

import com.lvr.Build.a.bear.appconfiguration.DuplicateEntityException;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorService {
  private final ColorRepository colorRepository;

  public List<BearColor> getAll() {
    return colorRepository.findAll();
  }

  public BearColor getById(UUID id) {
    return colorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public BearColor getByColor(String color) {
    return colorRepository.findByColorIgnoreCase(color).orElseThrow(EntityNotFoundException::new);
  }

  public void save(BearColor color) throws DuplicateEntityException {
    BearColor colorDupe = colorRepository.findByColorIgnoreCase(color.getColor()).orElse(null);
    if (colorDupe != null) {
      throw new DuplicateEntityException("color already exists");
    }
    colorRepository.save(color);
  }

  public BearColor update(UUID id, BearColor patch) {
    BearColor patchedColor = colorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    if (patch.getColor() != null) patchedColor.setColor(patch.getColor());
    colorRepository.save(patchedColor);
    return patchedColor;
  }

  public void delete(UUID id) {
    colorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    colorRepository.deleteById(id);
  }
}

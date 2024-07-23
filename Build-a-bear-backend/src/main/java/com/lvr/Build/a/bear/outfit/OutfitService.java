package com.lvr.Build.a.bear.outfit;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutfitService {
  private final OutfitRepository outfitRepository;

  public List<Outfit> getAll() {
    return outfitRepository.findAll();
  }

  public Outfit getById(UUID id) {
    return outfitRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public Outfit getByName(String name) {
    return outfitRepository.findByNameIgnoreCase(name).orElseThrow(EntityNotFoundException::new);
  }

  public void save(Outfit outfit) {
    outfitRepository.save(outfit);
  }

  public Outfit update(UUID id, Outfit patch) {
    Outfit patchedOutfit = outfitRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    if (patch.getHead() != null) patchedOutfit.setHead((patch.getHead()));
    if (patch.getChest() != null) patchedOutfit.setChest((patch.getChest()));
    if (patch.getFeet() != null) patchedOutfit.setFeet((patch.getFeet()));
    outfitRepository.save(patchedOutfit);
    return patchedOutfit;
  }

  public void delete(UUID id) {
    outfitRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    outfitRepository.deleteById(id);
  }
}

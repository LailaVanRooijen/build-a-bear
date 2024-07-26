package com.lvr.Build.a.bear.furpattern;

import com.lvr.Build.a.bear.appconfiguration.DuplicateEntityException;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FurPatternService {
  private final FurPatternRepository furPatternRepository;

  public List<FurPattern> getAll() {
    return furPatternRepository.findAll();
  }

  public FurPattern getById(UUID id) {
    return furPatternRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public FurPattern getByFurPattern(String furPattern) {
    return furPatternRepository
        .findByFurPatternIgnoreCase(furPattern)
        .orElseThrow(EntityNotFoundException::new);
  }

  public void save(FurPattern furPattern) throws DuplicateEntityException {
    FurPattern patternDupe =
        furPatternRepository.findByFurPatternIgnoreCase(furPattern.getFurPattern()).orElse(null);
    if (patternDupe != null) {
      throw new DuplicateEntityException("pattern already exists");
    }
    furPatternRepository.save(furPattern);
  }

  public FurPattern update(UUID id, FurPattern patch) {
    FurPattern patchedFurPattern =
        furPatternRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    if (patch.getFurPattern() != null) patchedFurPattern.setFurPattern(patch.getFurPattern());
    furPatternRepository.save(patchedFurPattern);
    return patchedFurPattern;
  }

  public void delete(UUID id) {
    furPatternRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    furPatternRepository.deleteById(id);
  }
}

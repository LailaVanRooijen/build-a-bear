package com.lvr.Build.a.bear.furtype;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FurTypeService {
  private final FurTypeRepository furTypeRepository;

  public List<FurType> getAll() {
    return furTypeRepository.findAll();
  }

  public FurType getById(UUID id) {
    return furTypeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public FurType getByFurType(String furType) {
    return furTypeRepository
        .findByFurTypeIgnoreCase(furType)
        .orElseThrow(EntityNotFoundException::new);
  }

  public void save(FurType furType) {
    furTypeRepository.save(furType);
  }

  public FurType update(UUID id, FurType patch) {
    FurType patchedFurType =
        furTypeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    if (patch.getFurType() != null) patchedFurType.setFurType(patch.getFurType());
    furTypeRepository.save(patchedFurType);
    return patchedFurType;
  }

  public void delete(UUID id) {
    furTypeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    furTypeRepository.deleteById(id);
  }
}

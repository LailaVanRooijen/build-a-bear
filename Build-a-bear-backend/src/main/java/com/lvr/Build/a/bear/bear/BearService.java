package com.lvr.Build.a.bear.bear;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BearService {
  private final BearRepository bearRepository;

  public List<Bear> getAll() {
    return bearRepository.findAll();
  }

  public Bear getById(UUID id) {
    return bearRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public void save(Bear bear) {
    bearRepository.save(bear);
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

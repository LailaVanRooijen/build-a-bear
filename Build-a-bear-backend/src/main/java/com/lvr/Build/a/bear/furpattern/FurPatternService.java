package com.lvr.Build.a.bear.furpattern;

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

    public void save(FurPattern furPattern) {
        furPatternRepository.save(furPattern);
    }

    public FurPattern update(UUID id, FurPattern patch) {
        FurPattern patchedFurPattern = furPatternRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if(patch.getFurPattern()!=null) patchedFurPattern.setFurPattern(patch.getFurPattern());
        furPatternRepository.save(patchedFurPattern);
        return patchedFurPattern;
    }

    public void delete(UUID id) {
        furPatternRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        furPatternRepository.deleteById(id);
    }
}
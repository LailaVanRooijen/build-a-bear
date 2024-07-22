package com.lvr.Build.a.bear.bear;

import com.lvr.Build.a.bear.bearcolor.ColorRepository;
import com.lvr.Build.a.bear.outfit.OutfitRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BearService {
  private final BearRepository bearRepository;
  private final ColorRepository colorRepository;
  private final OutfitRepository outfitRepository;

  public List<GetBearDto> getAll() {
    List<Bear> bears = bearRepository.findAll();
    return bears.stream().map(GetBearDto::convertToDto).toList();
  }

  public GetBearDto getById(UUID id) {
    Bear bear = bearRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    return GetBearDto.convertToDto(bear);
  }

  public Bear save(BearCreationDto dto) {
    Bear bear = dto.toBear(colorRepository, outfitRepository);
    bearRepository.save(bear);
    return null;
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

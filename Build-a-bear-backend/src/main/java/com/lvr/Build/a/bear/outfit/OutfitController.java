package com.lvr.Build.a.bear.outfit;

import static com.lvr.Build.a.bear.appconfiguration.Routes.OUTFITS;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"${client}"})
@RequestMapping(OUTFITS)
public class OutfitController {
  private final OutfitService outfitService;

  @GetMapping
  public ResponseEntity<List<Outfit>> getAll() {
    return ResponseEntity.ok(outfitService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Outfit> getAllById(@PathVariable UUID id) {
    return ResponseEntity.ok(outfitService.getById(id));
  }

  @PostMapping
  public ResponseEntity<Outfit> create(@RequestBody OutfitCreationDto dto) {
    Outfit outfit = dto.toOutfit();
    outfitService.save(outfit);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/id")
            .buildAndExpand(outfit.getId())
            .toUri();
    return ResponseEntity.created(location).body(outfit);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Outfit> update(@PathVariable UUID id, @RequestBody Outfit patch) {
    return ResponseEntity.ok(outfitService.update(id, patch));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Outfit> delete(@PathVariable UUID id) {
    outfitService.delete(id);
    return ResponseEntity.ok().build();
  }
}

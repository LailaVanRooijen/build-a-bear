package com.lvr.Build.a.bear.furpattern;

import static com.lvr.Build.a.bear.appconfiguration.Routes.FURPATTERNS;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import com.lvr.Build.a.bear.appconfiguration.DuplicateEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"${client}"})
@RequestMapping(FURPATTERNS)
public class FurPatternController {
  private final FurPatternService furPatternService;

  @GetMapping
  public ResponseEntity<List<FurPattern>> getAll() {
    return ResponseEntity.ok(furPatternService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<FurPattern> getAllById(@PathVariable UUID id) {
    return ResponseEntity.ok(furPatternService.getById(id));
  }

  @PostMapping
  public ResponseEntity<FurPattern> create(@RequestBody FurPattern furPattern)
      throws DuplicateEntityException {
    furPatternService.save(furPattern);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/id")
            .buildAndExpand(furPattern.getId())
            .toUri();
    return ResponseEntity.created(location).body(furPattern);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<FurPattern> update(@PathVariable UUID id, @RequestBody FurPattern patch) {
    return ResponseEntity.ok(furPatternService.update(id, patch));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<FurPattern> delete(@PathVariable UUID id) {
    furPatternService.delete(id);
    return ResponseEntity.ok().build();
  }
}

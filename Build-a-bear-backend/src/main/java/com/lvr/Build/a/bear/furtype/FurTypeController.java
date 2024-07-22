package com.lvr.Build.a.bear.furtype;

import static com.lvr.Build.a.bear.appconfiguration.Routes.FURTYPES;

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
@RequestMapping(FURTYPES)
public class FurTypeController {
  private final FurTypeService furTypeService;

  @GetMapping
  public ResponseEntity<List<FurType>> getAll() {
    return ResponseEntity.ok(furTypeService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<FurType> getAllById(@PathVariable UUID id) {
    return ResponseEntity.ok(furTypeService.getById(id));
  }

  @PostMapping
  public ResponseEntity<FurType> create(@RequestBody FurType furType) {
    furTypeService.save(furType);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/id")
            .buildAndExpand(furType.getId())
            .toUri();
    return ResponseEntity.created(location).body(furType);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<FurType> update(@PathVariable UUID id, @RequestBody FurType patch) {
    return ResponseEntity.ok(furTypeService.update(id, patch));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<FurType> delete(@PathVariable UUID id) {
    furTypeService.delete(id);
    return ResponseEntity.ok().build();
  }
}

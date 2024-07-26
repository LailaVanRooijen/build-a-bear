package com.lvr.Build.a.bear.bearcolor;

import static com.lvr.Build.a.bear.appconfiguration.Routes.COLORS;

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
@RequestMapping(COLORS)
public class ColorController {
  private final ColorService colorService;

  @GetMapping
  public ResponseEntity<List<BearColor>> getAll() {
    return ResponseEntity.ok(colorService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<BearColor> getAllById(@PathVariable UUID id) {
    return ResponseEntity.ok(colorService.getById(id));
  }

  @PostMapping
  public ResponseEntity<BearColor> create(@RequestBody BearColor color)
      throws DuplicateEntityException {
    colorService.save(color);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/id")
            .buildAndExpand(color.getId())
            .toUri();
    return ResponseEntity.created(location).body(color);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<BearColor> update(@PathVariable UUID id, @RequestBody BearColor patch) {
    return ResponseEntity.ok(colorService.update(id, patch));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<BearColor> delete(@PathVariable UUID id) {
    colorService.delete(id);
    return ResponseEntity.ok().build();
  }
}

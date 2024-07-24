package com.lvr.Build.a.bear.bear;

import static com.lvr.Build.a.bear.appconfiguration.Routes.BEARS;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping(BEARS)
public class BearController {
  private final BearService bearService;

  @GetMapping
  public ResponseEntity<List<GetBearDto>> getAll(
      @RequestParam(required = false, name = "color") List<String> colors,
      @RequestParam(required = false, name = "fur-type") List<String> furTypes,
      @RequestParam(required = false, name = "fur-pattern") List<String> furPatterns,
      @RequestParam(required = false, name = "voice") List<String> voices,
      @RequestParam(required = false, name = "outfit") List<String> outfits) {
    return ResponseEntity.ok(bearService.getAll(colors, furTypes, furPatterns, voices, outfits));
  }

  @GetMapping("/{id}")
  public ResponseEntity<GetBearDto> getAllById(@PathVariable UUID id) {
    return ResponseEntity.ok(bearService.getById(id));
  }
  
  @PostMapping
  public ResponseEntity<Bear> create(@RequestBody BearCreationDto dto) {
    Bear bear = bearService.save(dto);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/id")
            .buildAndExpand(bear.getId())
            .toUri();
    return ResponseEntity.created(location).body(bear);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Bear> update(@PathVariable UUID id, @RequestBody Bear patch) {
    return ResponseEntity.ok(bearService.update(id, patch));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Bear> delete(@PathVariable UUID id) {
    bearService.delete(id);
    return ResponseEntity.ok().build();
  }
}

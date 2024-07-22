package com.lvr.Build.a.bear.voice;

import static com.lvr.Build.a.bear.appconfiguration.Routes.VOICES;

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
@RequestMapping(VOICES)
public class VoiceController {
    private final VoiceService voiceService;

    @GetMapping
    public ResponseEntity<List<Voice>> getAll() {
        return ResponseEntity.ok(voiceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voice> getAllById(@PathVariable UUID id) {
        return ResponseEntity.ok(voiceService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Voice> create(@RequestBody Voice voice) {
        voiceService.save(voice);
        URI location =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/id")
                        .buildAndExpand(voice.getId())
            .toUri();
        return ResponseEntity.created(location).body(voice);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Voice> update(@PathVariable UUID id, @RequestBody Voice patch) {
        return ResponseEntity.ok(voiceService.update(id, patch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Voice> delete(@PathVariable UUID id) {
        voiceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
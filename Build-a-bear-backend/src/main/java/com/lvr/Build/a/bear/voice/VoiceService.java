package com.lvr.Build.a.bear.voice;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoiceService {
    private final VoiceRepository voiceRepository;

    public List<Voice> getAll() {
        return voiceRepository.findAll();
    }

    public Voice getById(UUID id) {
        return voiceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void save(Voice voice) {
        voiceRepository.save(voice);
    }

    public Voice update(UUID id, Voice patch) {
        Voice patchedVoice = voiceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if(patch.getVoice()!=null) patchedVoice.setVoice(patch.getVoice());
        voiceRepository.save(patchedVoice);
        return patchedVoice;
    }

    public void delete(UUID id) {
        voiceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        voiceRepository.deleteById(id);
    }
}
package com.lvr.Build.a.bear.voice;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoiceRepository extends JpaRepository<Voice, UUID> {
  Optional<Voice> findByVoiceIgnoreCase(String voice);
}

package com.lvr.Build.a.bear.furpattern;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurPatternRepository extends JpaRepository<FurPattern, UUID> {
  Optional<FurPattern> findByFurPatternIgnoreCase(String furPattern);
}

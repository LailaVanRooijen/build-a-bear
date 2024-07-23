package com.lvr.Build.a.bear.bearcolor;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<BearColor, UUID> {
  Optional<BearColor> findByColorIgnoreCase(String name);
}

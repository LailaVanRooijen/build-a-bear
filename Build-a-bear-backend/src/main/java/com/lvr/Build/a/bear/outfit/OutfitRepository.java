package com.lvr.Build.a.bear.outfit;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutfitRepository extends JpaRepository<Outfit, UUID> {
    Optional<Outfit> findByNameIgnoreCase(String name);
}

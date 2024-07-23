package com.lvr.Build.a.bear.furtype;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurTypeRepository extends JpaRepository<FurType, UUID> {
  Optional<FurType> findByFurTypeIgnoreCase(String name);
}

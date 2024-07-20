package com.lvr.Build.a.bear.bear;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BearRepository extends JpaRepository<Bear, UUID> {
}

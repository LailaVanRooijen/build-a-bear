package com.lvr.Build.a.bear.bear;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BearRepository extends JpaRepository<Bear, UUID>, JpaSpecificationExecutor<Bear> {}

package com.lvr.Build.a.bear.bearcolor;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<BearColor, UUID> {}

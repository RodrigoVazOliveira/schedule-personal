package dev.devaz.infra.repository;

import dev.devaz.infra.entity.MarkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkingEntityRepository extends JpaRepository<MarkingEntity, Long> {
}

package dev.devaz.schedule.repository;

import dev.devaz.schedule.entity.MarkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkingEntityRepository extends JpaRepository<MarkingEntity, Long> {
}

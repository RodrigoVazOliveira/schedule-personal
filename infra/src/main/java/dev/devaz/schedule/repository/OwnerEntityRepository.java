package dev.devaz.schedule.repository;

import dev.devaz.schedule.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerEntityRepository extends JpaRepository<OwnerEntity, Long> {
    Boolean existsByEmail(String email);
}

package dev.devaz.infra.repository;

import dev.devaz.infra.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerEntityRepository extends JpaRepository<OwnerEntity, Long> {
}

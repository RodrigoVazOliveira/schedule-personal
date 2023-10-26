package dev.devaz.schedule.gateway;

import dev.devaz.schedule.core.domain.owner.Owner;
import dev.devaz.schedule.core.usecase.owner.OwnerRepositoryUseCase;
import dev.devaz.schedule.entity.OwnerEntity;
import dev.devaz.schedule.repository.OwnerEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OwnerPersistence implements OwnerRepositoryUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(OwnerPersistence.class);
    private final OwnerEntityRepository ownerEntityRepository;

    public OwnerPersistence(OwnerEntityRepository ownerEntityRepository) {
        this.ownerEntityRepository = ownerEntityRepository;
    }

    @Override
    public Iterable<Owner> getAll() {
        LOGGER.info("getting all owners");
        final List<OwnerEntity> ownerEntities = ownerEntityRepository.findAll();
        List<Owner> owners = new ArrayList<>();
        ownerEntities.forEach(ownerEntity -> owners.add(ownerEntity.convertToOwner()));

        return owners;
    }

    @Override
    public Owner save(Owner owner) {
        LOGGER.info("saving in database");
        final OwnerEntity ownerEntity = OwnerEntity.convertOwnerToOwnerEntity(owner);
        final OwnerEntity ownerSaved = ownerEntityRepository.save(ownerEntity);

        return ownerSaved.convertToOwner();
    }

    @Override
    public Optional<Owner> getById(Long id) {
        LOGGER.info("find owner by id");
        Optional<OwnerEntity> optionalOwnerEntity = ownerEntityRepository.findById(id);
        if (optionalOwnerEntity.isEmpty()) {
            LOGGER.warn("not found ownerentity");

            return Optional.empty();
        }

        final OwnerEntity ownerEntity = optionalOwnerEntity.get();

        return Optional.of(ownerEntity.convertToOwner());
    }

    @Override
    public Boolean existsByEmail(String email) {
        LOGGER.info("exists owner by email");
        return ownerEntityRepository.existsByEmail(email);
    }

}

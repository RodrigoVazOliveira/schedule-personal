package dev.devaz.infra;

import dev.devaz.schedule.core.domain.owner.Owner;
import dev.devaz.schedule.core.usecase.owner.OwnerRepositoryUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OwnerPersistence implements OwnerRepositoryUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(OwnerPersistence.class);
    @Override
    public Iterable<Owner> getAll() {
        return null;
    }

    @Override
    public Owner save(Owner owner) {
        return null;
    }

    @Override
    public Optional<Owner> getById(Long id) {
        return Optional.empty();
    }
}

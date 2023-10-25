package dev.devaz.schedule.core.usecase.owner;

import dev.devaz.schedule.core.domain.owner.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAllOwner implements GetAllOwnerUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(GetAllOwner.class);
    private final OwnerRepositoryUseCase ownerRepositoryUseCase;

    public GetAllOwner(OwnerRepositoryUseCase ownerRepositoryUseCase) {
        this.ownerRepositoryUseCase = ownerRepositoryUseCase;
    }

    @Override
    public Iterable<Owner> execute() {
        LOGGER.info("getting all owners");

        return ownerRepositoryUseCase.getAll();

    }
}

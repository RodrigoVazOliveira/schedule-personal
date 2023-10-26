package dev.devaz.schedule.entrypoint.owner;

import dev.devaz.schedule.core.domain.owner.Owner;
import dev.devaz.schedule.core.usecase.owner.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OwnerEntryPoint implements OwnerEntryPointUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(OwnerEntryPoint.class);
    private final SaveOwnerUseCase saveOwnerUseCase;
    private final GetAllOwnerUseCase getAllOwnerUseCase;
    private final GetOwnerByIdUseCase getOwnerByIdUseCase;

    public OwnerEntryPoint(SaveOwnerUseCase saveOwnerUseCase, GetAllOwnerUseCase getAllOwnerUseCase, GetOwnerByIdUseCase getOwnerByIdUseCase) {
        this.saveOwnerUseCase = saveOwnerUseCase;
        this.getAllOwnerUseCase = getAllOwnerUseCase;
        this.getOwnerByIdUseCase = getOwnerByIdUseCase;
    }

    @Override
    public Owner saveNewOwner(Owner owner) {
        LOGGER.info("saving new owner");

        return saveOwnerUseCase.execute(owner);
    }

    @Override
    public Owner getOwnerById(Long id) {
        LOGGER.info("get owner by id");

        return getOwnerByIdUseCase.execute(id);
    }

    @Override
    public Iterable<Owner> getAllOwners() {
        LOGGER.info("get all owners");

        return getAllOwnerUseCase.execute();
    }
}

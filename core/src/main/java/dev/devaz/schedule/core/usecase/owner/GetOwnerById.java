package dev.devaz.schedule.core.usecase.owner;

import dev.devaz.schedule.core.domain.owner.Owner;
import dev.devaz.schedule.core.domain.owner.exception.OwnerNotFoundException;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class GetOwnerById implements GetOwnerByIdUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(GetOwnerById.class);
    private final OwnerRepositoryUseCase ownerRepositoryUseCase;

    public GetOwnerById(OwnerRepositoryUseCase ownerRepositoryUseCase) {
        this.ownerRepositoryUseCase = ownerRepositoryUseCase;
    }

    @Override
    public Owner execute(Long id) {
        LOGGER.info("getting owner by id. {}", StructuredArguments.keyValue("id", id));
        Optional<Owner> ownerOptional = ownerRepositoryUseCase.getById(id);
        if (ownerOptional.isEmpty()) {
            LOGGER.warn("Not found owner by id.");

            throw new OwnerNotFoundException("not found owner by id " + id);
        }

        return ownerOptional.get();
    }
}

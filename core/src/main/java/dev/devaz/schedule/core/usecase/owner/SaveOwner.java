package dev.devaz.schedule.core.usecase.owner;

import dev.devaz.schedule.core.domain.owner.Owner;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class SaveOwner implements SaveOwnerUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(SaveOwner.class);
    private final OwnerRepositoryUseCase ownerRepositoryUseCase;

    public SaveOwner(OwnerRepositoryUseCase ownerRepositoryUseCase) {
        this.ownerRepositoryUseCase = ownerRepositoryUseCase;
    }

    @Override
    public Owner execute(Owner owner) {
        LOGGER.info("saving owner {}", StructuredArguments.keyValue("owner", owner));
        final Owner ownerSave = new Owner(owner.id(), owner.firstName(), owner.lastName(), owner.dateOfBirth(), owner.email(), LocalDateTime.now(), LocalDateTime.now());
        final Owner ownerSaved = ownerRepositoryUseCase.save(ownerSave);

        LOGGER.info("owner saved {}", StructuredArguments.keyValue("id", ownerSaved.id()));

        return ownerSaved;
    }
}

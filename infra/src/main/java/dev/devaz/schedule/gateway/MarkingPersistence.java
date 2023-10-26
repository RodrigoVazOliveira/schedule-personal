package dev.devaz.schedule.gateway;

import dev.devaz.schedule.core.domain.marking.Marking;
import dev.devaz.schedule.core.usecase.making.MarkingRepositoryUseCase;
import dev.devaz.schedule.entity.MarkingEntity;
import dev.devaz.schedule.entity.OwnerEntity;
import dev.devaz.schedule.repository.MarkingEntityRepository;
import dev.devaz.schedule.repository.OwnerEntityRepository;
import jakarta.transaction.Transactional;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class MarkingPersistence implements MarkingRepositoryUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(MarkingPersistence.class);
    private final MarkingEntityRepository markingEntityRepository;
    private final OwnerEntityRepository ownerEntityRepository;

    public MarkingPersistence(MarkingEntityRepository markingEntityRepository, OwnerEntityRepository ownerEntityRepository) {
        this.markingEntityRepository = markingEntityRepository;
        this.ownerEntityRepository = ownerEntityRepository;
    }

    @Override
    public Optional<Marking> getMerkingById(Long id) {
        LOGGER.info("Getting marking entity");
        Optional<MarkingEntity> optionalMarkingEntity = markingEntityRepository.findById(id);
        if (optionalMarkingEntity.isEmpty()) {
            LOGGER.warn("not found marking entity by id");

            return Optional.empty();
        }
        final MarkingEntity markingEntity = optionalMarkingEntity.get();
        LOGGER.info("getting {}", StructuredArguments.keyValue("markingEntity", markingEntity));

        return Optional.of(markingEntity.convertToMarking());
    }

    @Override
    public Marking save(Marking marking) {
        LOGGER.info("saving marking");
        if (Objects.isNull(marking.id())) {
            final MarkingEntity markingEntity = MarkingEntity.convertMarkingToMarkingEntity(marking, ownerEntityRepository);
            MarkingEntity markingEntitySaved = markingEntityRepository.save(markingEntity);

            return markingEntitySaved.convertToMarking();
        } else {
            Optional<MarkingEntity> markingEntityOptional = markingEntityRepository.findById(marking.id());
            MarkingEntity markingEntityOld = markingEntityOptional.get();
            final OwnerEntity ownerEntity = ownerEntityRepository.findById(marking.owner().id()).get();
            List<OwnerEntity> ownerEntities = new ArrayList<>();
            marking.invites().forEach(owner -> ownerEntities.add(ownerEntityRepository.findById(owner.id()).get()));

            LOGGER.info("{}", StructuredArguments.keyValue("markingEntityOptional", markingEntityOptional));
            markingEntityOld.setOwnerEntity(ownerEntity);
            markingEntityOld.setName(marking.name());
            markingEntityOld.setDescription(marking.description());
            markingEntityOld.setInvites(ownerEntities);
            markingEntityOld.setDateTimeInviteInitial(marking.dateTimeInviteInitial());
            markingEntityOld.setDateTimeInviteFinal(marking.dateTimeInviteFinal());
            markingEntityOld.setDateTimeCreated(markingEntityOld.getDateTimeCreated());
            markingEntityOld.setDateTimeUpdated(marking.dateTimeUpdated());

            MarkingEntity markingEntityUpdated = markingEntityRepository.save(markingEntityOld);

            return markingEntityUpdated.convertToMarking();
        }

    }

    @Override
    public Iterable<Marking> getAll() {
        LOGGER.info("getting all marking in database");
        final List<MarkingEntity> markingEntities = markingEntityRepository.findAll();
        return markingEntities.stream().map(MarkingEntity::convertToMarking).collect(Collectors.toList());
    }
}

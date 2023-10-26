package dev.devaz.schedule.gateway;

import dev.devaz.schedule.entity.MarkingEntity;
import dev.devaz.schedule.repository.MarkingEntityRepository;
import dev.devaz.schedule.core.domain.marking.Marking;
import dev.devaz.schedule.core.usecase.making.MarkingRepositoryUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MarkingPersistence implements MarkingRepositoryUseCase {
    private final static Logger LOGGER = LoggerFactory.getLogger(MarkingPersistence.class);
    private final MarkingEntityRepository markingEntityRepository;

    public MarkingPersistence(MarkingEntityRepository markingEntityRepository) {
        this.markingEntityRepository = markingEntityRepository;
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

        return Optional.of(markingEntity.convertToMarking());
    }

    @Override
    public Boolean existsMarkingById(Long id) {
        LOGGER.info("verify is exists marking by id");
        return markingEntityRepository.existsById(id);
    }

    @Override
    public Marking save(Marking marking) {
        LOGGER.info("saving marking");
        final MarkingEntity markingEntity = MarkingEntity.convertMarkingToMarkingEntity(marking);
        MarkingEntity markingEntitySaved = markingEntityRepository.save(markingEntity);

        return markingEntitySaved.convertToMarking();
    }
}

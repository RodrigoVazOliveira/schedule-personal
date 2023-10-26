package dev.devaz.schedule.configuration;

import dev.devaz.schedule.core.usecase.owner.GetAllOwner;
import dev.devaz.schedule.core.usecase.owner.GetOwnerById;
import dev.devaz.schedule.core.usecase.owner.OwnerRepositoryUseCase;
import dev.devaz.schedule.core.usecase.owner.SaveOwner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OwnerBeanConfiguration {

    @Bean
    GetAllOwner getAllOwner(OwnerRepositoryUseCase ownerRepositoryUseCase) {
        return new GetAllOwner(ownerRepositoryUseCase);
    }

    @Bean
    GetOwnerById getOwnerById(OwnerRepositoryUseCase ownerRepositoryUseCase) {
        return new GetOwnerById(ownerRepositoryUseCase);
    }

    @Bean
    SaveOwner saveOwner(OwnerRepositoryUseCase ownerRepositoryUseCase) {
        return new SaveOwner(ownerRepositoryUseCase);
    }
}

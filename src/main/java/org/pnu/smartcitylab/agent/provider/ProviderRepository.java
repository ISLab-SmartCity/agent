package org.pnu.smartcitylab.agent.provider;

import org.pnu.smartcitylab.agent.entity.ProviderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProviderRepository extends MongoRepository<ProviderEntity, String> {
    long count();
}

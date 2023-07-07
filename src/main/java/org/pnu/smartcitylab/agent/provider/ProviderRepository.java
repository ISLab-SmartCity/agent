package org.pnu.smartcitylab.agent.provider;

import org.pnu.smartcitylab.agent.entity.ProviderEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends MongoRepository<ProviderEntity, String> { }



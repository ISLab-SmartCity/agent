package org.pnu.smartcitylab.agent.device;

import org.pnu.smartcitylab.agent.entity.DeviceEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends MongoRepository<DeviceEntity, String> { }

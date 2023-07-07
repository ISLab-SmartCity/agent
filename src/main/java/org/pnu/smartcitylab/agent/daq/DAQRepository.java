package org.pnu.smartcitylab.agent.daq;

import org.pnu.smartcitylab.agent.entity.DAQEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DAQRepository extends MongoRepository<DAQEntity, String> {}

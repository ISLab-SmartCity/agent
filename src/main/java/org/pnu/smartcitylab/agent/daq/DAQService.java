package org.pnu.smartcitylab.agent.daq;

import lombok.AllArgsConstructor;
import org.pnu.smartcitylab.agent.daq.dto.DaqDTO;
import org.pnu.smartcitylab.agent.device.DeviceRepository;
import org.pnu.smartcitylab.agent.entity.DAQEntity;
import org.pnu.smartcitylab.agent.entity.DeviceEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DAQService {
    private DAQRepository daqRepository;
    private DeviceRepository deviceRepository;
    private MongoTemplate mongoTemplate;

    public DAQEntity createData(DaqDTO dto){
        DAQEntity item = new DAQEntity(dto.getDevice_id(), dto.getTimestamp(), dto.getData());
        return daqRepository.save(item);
    }

    public List<DAQEntity> getDaq(String device_id) throws Exception {
        Optional<DeviceEntity> device = deviceRepository.findById(device_id);
        if(device.isEmpty()){
            throw new Exception("기기 정보가 없습니다.");
        }
        Query query = new Query();
        query.addCriteria(Criteria.where("device_id").is(device_id));
        return mongoTemplate.find(query, DAQEntity.class);
    }
}

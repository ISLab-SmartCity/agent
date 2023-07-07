package org.pnu.smartcitylab.agent.device;

import lombok.AllArgsConstructor;
import org.pnu.smartcitylab.agent.device.dto.CreateDeviceDTO;
import org.pnu.smartcitylab.agent.device.dto.UpdateDeviceDTO;
import org.pnu.smartcitylab.agent.entity.DeviceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    public DeviceEntity createDevice(CreateDeviceDTO dto) {
        String id = UUID.randomUUID().toString();
        dto.setDevice_id(id);
        DeviceEntity device = new DeviceEntity( dto.getProvider_id(), dto.getDevice_id(),dto.getDevice_nm(), dto.getDevice_addr(), dto.getDevice_type());
        return deviceRepository.save(device);
    }

    public List<DeviceEntity> getDeviceList(){
        return deviceRepository.findAll();
    }

    public Optional<DeviceEntity> getDevice(String id) throws Exception {
        Optional<DeviceEntity> device = deviceRepository.findById(id);
        if(device.isEmpty()){
            throw new Exception("기기 정보가 없습니다.");
        }
        return device;
    }

    public DeviceEntity updateDevice(UpdateDeviceDTO dto) throws Exception {
        Optional<DeviceEntity> device = deviceRepository.findById(dto.getDevice_id());
        if(device.isEmpty()){
            throw new Exception("기기 정보가 없습니다.");
        }
        DeviceEntity item = new DeviceEntity(dto.getDevice_id(), dto.getDevice_nm(), dto.getDevice_addr(), dto.getDevice_type());
        return deviceRepository.save(item);
    }

    public String deleteDevice(String id) throws Exception {
        Optional<DeviceEntity> device = deviceRepository.findById(id);
        if(device.isEmpty()){
            throw new Exception("기기 정보가 없습니다.");
        }
        deviceRepository.deleteById(id);
        return id;
    }
}

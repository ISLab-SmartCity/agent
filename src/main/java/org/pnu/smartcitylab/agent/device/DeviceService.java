package org.pnu.smartcitylab.agent.device;

import lombok.AllArgsConstructor;
import org.pnu.smartcitylab.agent.device.dto.CreateDeviceDTO;
import org.pnu.smartcitylab.agent.entity.DeviceEntity;
import org.pnu.smartcitylab.agent.repository.DeviceRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    public DeviceEntity createDevice(CreateDeviceDTO dto) {
        DeviceEntity device = new DeviceEntity(dto.getProvider_id(), dto.getDevice_id(), dto.getDevice_nm(), dto.getDevice_addr(), dto.getDevice_type());
        return deviceRepository.save(device);
    }
}

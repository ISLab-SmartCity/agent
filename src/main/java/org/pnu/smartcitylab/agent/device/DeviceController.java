package org.pnu.smartcitylab.agent.device;

import lombok.AllArgsConstructor;
import org.pnu.smartcitylab.agent.config.ApiResponseMessage;
import org.pnu.smartcitylab.agent.device.dto.CreateDeviceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
@AllArgsConstructor
public class DeviceController {
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<?> createDevice(@RequestBody CreateDeviceDTO dto) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", deviceService.createDevice(dto));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}

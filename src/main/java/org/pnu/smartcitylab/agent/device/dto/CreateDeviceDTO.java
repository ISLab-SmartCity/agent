package org.pnu.smartcitylab.agent.device.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class CreateDeviceDTO {
    @Schema(description = "기기 고유 번호", defaultValue = "uuid")
    @Id
    private String device_id;

    @Schema(description = "업체 고유 번호", defaultValue = "uuid")
    private String provider_id;

    @Schema(description = "기기명", defaultValue = "스마트엠투엠-태양광발전기1호")
    private String device_nm;

    @Schema(description = "기기 주소", defaultValue = "??")
    private String device_addr;

    @Schema(description = "기기 유형", defaultValue = "태양광발전기")
    private String device_type;
}
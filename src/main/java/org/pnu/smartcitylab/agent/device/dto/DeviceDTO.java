package org.pnu.smartcitylab.agent.device.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
public class DeviceDTO {
    @Schema(description = "업체 고유 번호", defaultValue = "uuid")
    private String provider_id;

    @Schema(description = "기기 고유 번호", defaultValue = "uuid", hidden = true)
    @Id
    private String device_id;

    @Schema(description = "업체명", defaultValue = "스마트엠투엠-태양광발전기1호")
    private String device_nm;

    @Schema(description = "기기주소", defaultValue = "??")
    private String device_addr;

    @Schema(description = "기기 유형", defaultValue = "태양광발전기")
    private String device_type;

    @Schema(description = "생성일자", defaultValue = "Timestamp")
    private Date created_at;

    @Schema(description = "최근수정일자", defaultValue = "Timestamp")
    private Date modified_at;
}

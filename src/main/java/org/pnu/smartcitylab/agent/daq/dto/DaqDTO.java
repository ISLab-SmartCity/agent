package org.pnu.smartcitylab.agent.daq.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class DaqDTO {
    @Schema(description = "기기 고유 번호", defaultValue = "uuid")
    private String device_id;
    @Schema(description = "생성일자", defaultValue = "Timestamp")
    private Date timestamp;
    @Schema(description = "센싱 데이터", defaultValue = "Object")
    private Object data;
}

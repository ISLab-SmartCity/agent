package org.pnu.smartcitylab.agent.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "sensing_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DAQEntity {

    @Schema(description = "기기 고유 번호", defaultValue = "uuid")
    private String device_id;
    @Schema(description = "생성일자", defaultValue = "Timestamp")
    private Date timestamp;
    @Schema(description = "센싱 데이터", defaultValue = "Object")
    private Object data;
}

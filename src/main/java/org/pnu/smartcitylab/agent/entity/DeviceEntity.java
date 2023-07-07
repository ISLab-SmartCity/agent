package org.pnu.smartcitylab.agent.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "device")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceEntity {
    @Schema(description = "업체 고유 번호", defaultValue = "uuid")
    private String provider_id;

    @Schema(description = "기기 고유 번호", defaultValue = "uuid", hidden = true)
    @Id
    private String device_id;

    @Schema(description = "기기명", defaultValue = "태양광발전기01호")
    private String device_nm;

    @Schema(description = "기기주소", defaultValue = "??")
    private String device_addr;

    @Schema(description = "기기 유형", defaultValue = "태양광발전기")
    private String device_type;

    @Schema(description = "기기 상세 정보", defaultValue = "Object")
    private Object detail;

    @Schema(description = "생성일자", defaultValue = "Timestamp")
    private Date created_at;

    @Schema(description = "최근수정일자", defaultValue = "Timestamp")
    private Date modified_at;

    //    CreateItem Constructor
    public DeviceEntity(String provider_id, String device_id, String device_nm, String device_addr, String device_type) {
        this.provider_id = provider_id;
        this.device_id = device_id;
        this.device_nm = device_nm;
        this.device_addr = device_addr;
        this.device_type = device_type;
        this.created_at = new Date();
        this.modified_at = new Date();
    }

    // UpdateItem Constructor
    public DeviceEntity(String device_id, String device_nm, String device_addr, String device_type) {
        this.device_id = device_id;
        this.device_nm = device_nm;
        this.device_addr = device_addr;
        this.device_type = device_type;
        this.modified_at = new Date();
    }

}

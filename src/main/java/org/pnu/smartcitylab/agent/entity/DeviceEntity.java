package org.pnu.smartcitylab.agent.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceEntity {
    @Schema(description = "업체 고유 번호", defaultValue = "uuid")
    @Id
    private String provider_id;

    @Schema(description = "기기 고유 번호", defaultValue = "uuid", hidden = true)
    @Id
    private String device_id;

    @Schema(description = "업체명", defaultValue = "스마트엠투엠")
    private String device_nm;

    @Schema(description = "업체 로그인 ID", defaultValue = "smartm2m")
    private String device_addr;

    @Schema(description = "업체 로그인 PW", defaultValue = "12347890")
    private String device_type;

    @Schema(description = "생성일자", defaultValue = "Timestamp")
    private Date created_at;

    @Schema(description = "최근수정일자", defaultValue = "Timestamp")
    private Date modified_at;

    //    CreateItem Constructor
    public DeviceEntity(String device_id, String provider_nm, String provider_login_id, String provider_login_pw) {
        this.device_id = device_id;
        this.device_nm = provider_nm;
        this.device_addr = provider_login_id;
        this.device_type = provider_login_pw;
        this.created_at = new Date();
        this.modified_at = new Date();
    }

}

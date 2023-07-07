package org.pnu.smartcitylab.agent.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "provider")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderEntity {
    @Schema(description = "업체 고유 번호", defaultValue = "uuid", hidden = true)
    @Id
    private String id;

    @Schema(description = "업체명", defaultValue = "스마트엠투엠")
    private String provider_nm;

    @Schema(description = "업체 로그인 ID", defaultValue = "smartm2m")
    private String provider_login_id;

    @Schema(description = "업체 로그인 PW", defaultValue = "12347890")
    private String provider_login_pw;

    @Schema(description = "생성일자", defaultValue = "Timestamp")
    private Date created_at;

    @Schema(description = "최근수정일자", defaultValue = "Timestamp")
    private Date modified_at;

    //    CreateItem Constructor
    public ProviderEntity(String id, String provider_nm, String provider_login_id, String provider_login_pw) {
        this.id = id;
        this.provider_nm = provider_nm;
        this.provider_login_id = provider_login_id;
        this.provider_login_pw = provider_login_pw;
        this.created_at = new Date();
        this.modified_at = new Date();
    }

    //  UpdateITem Constructor
    public ProviderEntity(String id, String provider_nm, String provider_login_pw) {
        this.id = id;
        this.provider_nm = provider_nm;
        this.provider_login_pw = provider_login_pw;
        this.modified_at = new Date();
    }
}

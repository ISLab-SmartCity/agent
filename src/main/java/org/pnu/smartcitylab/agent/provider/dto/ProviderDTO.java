package org.pnu.smartcitylab.agent.provider.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
public class ProviderDTO {
    @Schema(description = "업체 고유 번호", defaultValue = "uuid", hidden = true)
    @Id
    private String id;

    @Schema(description = "업체명", defaultValue = "스마트엠투엠")
    private String provider_nm;

    @Schema(description = "업체 로그인 ID", defaultValue = "smartm2m")
    private String provider_login_id;

    @Schema(description = "생성일자", defaultValue = "Timestamp")
    private Date created_at;

    @Schema(description = "최근수정일자", defaultValue = "Timestamp")
    private Date modified_at;
}

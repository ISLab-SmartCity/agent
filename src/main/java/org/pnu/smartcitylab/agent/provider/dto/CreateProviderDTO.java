package org.pnu.smartcitylab.agent.provider.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class CreateProviderDTO {
    @Schema(description = "업체 고유 번호", hidden = true)
    @Id
    private String id;
    @Schema(description = "업체명", defaultValue = "스마트엠투엠")
    private String provider_nm;

    @Schema(description = "업체 로그인 ID", defaultValue = "smartm2m")
    private String provider_login_id;

    @Schema(description = "업체 로그인 PW", defaultValue = "12347890")
    private String provider_login_pw;
}

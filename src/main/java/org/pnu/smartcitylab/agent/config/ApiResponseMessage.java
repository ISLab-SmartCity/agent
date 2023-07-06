package org.pnu.smartcitylab.agent.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseMessage {
    @Schema(description = "API 결과(Boolean)", defaultValue = "true")
    private Boolean result;
    @Schema(description = "결과 메시지", defaultValue = "Success")
    private String msg;
    @Schema(description = "에러코드", defaultValue = "400")
    private String errorCode;
    @Schema(description = "에러 메시지", defaultValue = "NullPointException")
    private String errorMsg;

    @Schema(description = "API 결과(Object)", defaultValue = "Object")
    private Object data;

    public ApiResponseMessage(Boolean result, String msg, String errorCode, String errorMsg) {
        this.result = result;
        this.msg = msg;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}

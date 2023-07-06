package org.pnu.smartcitylab.agent.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(@Value("v0.0.1") String springDocVersion) {
        Info info = new Info()
                .title("스마트시티랩 에이전트")
                .version(springDocVersion)
                .description("에이전트/디바이스 등록");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}

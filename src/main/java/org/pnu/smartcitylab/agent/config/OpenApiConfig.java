package org.pnu.smartcitylab.agent.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(@Value("v0.0.1") String springDocVersion, @Value("${server.url}") String serverUrl) {
        Info info = new Info()
                .title("스마트시티랩 에이전트")
                .version(springDocVersion)
                .description("가상공간 및 모의도시 플랫폼 연동 요소 기술 개발")
                .termsOfService("http://swagger.io/terms/")
                .contact(new Contact().name("Byeongwook Jung").url("https://github.com/ISLab-SmartCity/agent").email("byeonguk@islab.re.kr"))
                // .contact(new Contact().name("Kyeongwoo Oh").url("https://github.com/ISLab-SmartCity/agent").email("kyeongwoo@islab.re.kr"))
                .license(new License().name("Apache License Version 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"));
        Server server = new Server();
        server.setUrl(serverUrl);

        return new OpenAPI()
                .components(new Components())
                .servers(List.of(server))
                .info(info);
    }
}

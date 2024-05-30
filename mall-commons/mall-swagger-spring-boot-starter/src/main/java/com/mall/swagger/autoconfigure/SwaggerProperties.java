package com.mall.swagger.autoconfigure;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description Swagger 配置
 * @date 2023/05/25 17:05
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "mall.swagger")
public class SwaggerProperties {

    private boolean enabled = true;

    private String basePackage = "";

    private String title = "";

    private String groupName = "";

    private String description = "";

    private String version = "";

    private String host = "";

    private String license = "";

    private String licenseUrl = "";

    private String termsOfServiceUrl = "";

    private List<String> basePath = new ArrayList();

    private List<String> excludePath = new ArrayList();

    private Contact contact = new Contact();

    private Authorization authorization = new Authorization();


    @Data
    @NoArgsConstructor
    public static class Contact {

        private String name = "";

        private String url = "";

        private String email = "";
    }

    @Data
    @NoArgsConstructor
    public static class Authorization {

        private String name = "";

        private String authRegex = "^.*$";

        private List<AuthorizationScope> authorizationScopeList = new ArrayList<>();

        private List<String> tokenUrlList = new ArrayList<>();
    }

    @Data
    @NoArgsConstructor
    public static class AuthorizationScope {

        private String scope = "";

        private String description = "";
    }
}

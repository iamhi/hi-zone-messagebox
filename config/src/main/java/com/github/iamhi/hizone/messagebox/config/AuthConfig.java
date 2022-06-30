package com.github.iamhi.hizone.messagebox.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "messagebox.service.auth")
@Data
public class AuthConfig {

    String username;

    String password;

    String baseUrl;

    String accessTokenName;
}

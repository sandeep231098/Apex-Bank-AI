package com.apexbank.transaction.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI transactionOpenAPI() {

        final String securitySchemeName = "Bearer Authentication";

        return new OpenAPI()

                // API information
                .info(new Info()
                        .title("Apex Bank AI - Transaction Service API")
                        .description("Enterprise Banking Transaction APIs")
                        .version("v1.0.0")

                        .contact(new Contact()
                                .name("Apex Bank AI")
                                .email("support@apexbank.com"))

                        .license(new License()
                                .name("Apache 2.0")))

                // External documentation
                .externalDocs(new ExternalDocumentation()
                        .description("Apex Bank Documentation"))

                // JWT security requirement
                .addSecurityItem(
                        new SecurityRequirement()
                                .addList(securitySchemeName))

                // JWT Bearer configuration
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }
}
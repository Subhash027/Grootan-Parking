package com.grootan.parking.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.grootan.parking.constants.SwaggerConstants.*;

@Configuration
public class SwaggerConfiguration
{
    @Bean
    public OpenAPI parkingServiceOpenAPI()
    {
        return new OpenAPI()
                .info(new Info().title("Parking Lot Management System")
                        .title(TITLE)
                        .version(VERSION)
                        .description(DESCRIPTION)
                        .license(new License().name(LICENSE).url(WEBURL))
                        .termsOfService(TERMS_OF_SERVICE)
                );
    }
}

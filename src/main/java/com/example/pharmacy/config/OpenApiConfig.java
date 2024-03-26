package com.example.pharmacy.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Pharmacy API!",
        description = """
                
                """,
        contact = @Contact(
                name = "Tariel Akmatov",
                email = "tariel.akmatov@gmail.com"
        ),
        version = "v3",
        license = @License(
                name = "TrustMeBro Licence",
                url = "https://github.com/thombergs/code-examples/blob/master/LICENSE"))
)
public class OpenApiConfig {

    @Bean
    public OpenAPI customizeOpenAPI() {
            return new OpenAPI();
    }
}

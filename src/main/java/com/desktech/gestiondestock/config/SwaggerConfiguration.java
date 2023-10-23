package com.desktech.gestiondestock.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.desktech.gestiondestock.utils.constants.APP_ROOT;

//@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
   OpenAPI customOpenApi(){
       return new OpenAPI().info(new Info()
               .title("Gestion de stock")
               .version("v1")
               .description("Une API Rest de gestion de stock")
               .termsOfService("https://github.com/kevindeffo/gestiondestock")
               .license(new License().name("Apache 2.0")
                       .url("https://github.com/kevindeffo/gestiondestock"))
       );
   }
}

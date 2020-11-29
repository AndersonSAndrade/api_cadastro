/*
 * Copyright (c) 2020. Olá todos os direitos reservados para Anderson S. Andrade.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/CADASTRO/api/src/main/java/com/ads/api/config/SwaggerConfiguration.java)
 * Projeto: api -> api -> SwaggerConfiguration
 * Criador: andersons.andrade
 * Última Modificação: 29/11/2020 14:48
 */

package com.ads.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ads.api.rest.controllers"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "API REST Cadastro Usuários",
                "Cadastro geral de usuários para sistema.",
                "1.0",
                "Terms of Service",
                new Contact(
                        "Anderson S. Andradde",
                        "https://andersonsandrade.github.io/adsdev.github.io/",
                        "asantos919@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}

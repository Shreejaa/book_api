package com.Training.BookService.configuration;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@Configuration
@EnableSwagger2
public class BookConfigure {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.Training.BookService.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }

    //
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Book API")
                .description("Book Management REST API")
                .contact(new Contact("Shreejaa Talla", "www.epam.com", "Shreejaa_Talla@epam.com"))
                .build();
    }
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }


}
package com.shobhit.elasticsearch.SearchServices.configuration;

import org.elasticsearch.common.regex.Regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;

@Configuration
public class SpringFoxConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.shobhit.elasticsearch.SearchServices"))
        // .apis(RequestHandlerSelectors.any()) //for enabling all endpoints
        // including actuators, errors, operational
        .paths(PathSelectors.any()).build();
  }

}
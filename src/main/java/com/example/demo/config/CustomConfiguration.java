package com.example.demo.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class CustomConfiguration extends WebMvcConfigurationSupport{
	
    @Bean
    public Docket version1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select() 
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(regex(".*"+""+".*"))
                .build()
                .enable(true)
                .groupName("Extramarks-Employee-Version-1.0.0.0")
                .apiInfo(
                		new ApiInfoBuilder()
                		.description("Extramarks Employee APIs")
                		.title("Extramarks-Employee-Version-1.0.0.0")
                		.version("1.0.0.0")
                		.build()
                		)
               // .host("localhost:8186")
                ;
    }
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        
        
    }
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        
        modelMapper
        .getConfiguration()
        .setSkipNullEnabled(true)
        .setAmbiguityIgnored(true);
        
        return modelMapper;
    }
}

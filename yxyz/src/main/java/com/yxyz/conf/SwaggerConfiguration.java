package com.yxyz.conf;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration
{
	
	 @Bean
	 public Docket baseRestApi() 
	 {
	     return new Docket(DocumentationType.SWAGGER_2)
	     .apiInfo(apiInfo())
	     .select()
	     .apis(RequestHandlerSelectors.basePackage("com.yxyz"))
	     .paths(PathSelectors.any())
	     .build().directModelSubstitute(Timestamp.class, Date.class);
	 }

	 @Bean
	 public ApiInfo apiInfo() 
	 {
	     return new ApiInfoBuilder()
	     .title("接口文档")
	     .description("文档Swagger版")
	     .termsOfServiceUrl("")
	     .contact(new Contact("--","Author:ducl", ""))
	     .version("1.0")
	     .build();
	 }



}
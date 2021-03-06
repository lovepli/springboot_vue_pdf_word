package com.yxyz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.yxyz.dao")
@ComponentScan("com.yxyz.**")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableAsync
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class YxyzApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(YxyzApplication.class, args);
	}

}

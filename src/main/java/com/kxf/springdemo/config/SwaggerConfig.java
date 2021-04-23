package com.kxf.springdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//查看地址http://localhost:8080/swagger-ui.html
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${version}")
	private String version;
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .groupName("pringbootDemo V" + version)
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.kxf.springdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
    	Contact contact = new Contact("能吃三碗饭", "https://blog.csdn.net/qq_15345551", "1024883177@qq.com");
        return new ApiInfoBuilder()
                .title("pringboot测试工程")
                .description("pringboot测试工程API文档 V" + version)
                //服务条款网址
                .termsOfServiceUrl("https://github.com/kuangxuefeng")
                .version(version)
                .contact(contact)
                .build();
    }

}
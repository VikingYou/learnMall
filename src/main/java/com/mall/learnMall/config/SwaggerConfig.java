package com.mall.learnMall.config;


import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sun.security.util.SecurityConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ycd20
 * @date 2021/11/16
 * @time 23:17
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.mall.learnMall.controller"))
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                //添加登录认证
                .securitySchemes(securitySchemes())
                .securityContexts(Arrays.asList(securityContext()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("mall-tiny")
                .contact(new Contact("Ycd", "bafeimao.github.io", "ycd200709@163.com"))
                .version("1.0")
                .build();
    }


    /**
     * 设置授权信息
     */
    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> securitySchemes = new ArrayList<>();
        securitySchemes.add(HttpAuthenticationScheme.BASIC_AUTH_BUILDER.name("jwt").build());
        securitySchemes.add(HttpAuthenticationScheme.JWT_BEARER_BUILDER.name("basic").build());
        return securitySchemes;
    }

    private List<SecurityReference> securityReferences() {

        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("jwt", authorizationScopes));
        securityReferences.add(new SecurityReference("basic", authorizationScopes));
        return securityReferences;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(securityReferences()).forPaths(PathSelectors.any()).build();
    }

}


package com.luyi.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: luyi
 * @Description:Swagger配置文件
 * @Date: Created in 2022-05-18
 */
@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {

    /**
     * 构建 swagger2 api 文档的详细信息函数
     * @return
     */
    private ApiInfo initApiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("用户服务项目 UserServer API")//大标题
                .version( "1.0.0")//版本
                .description(initContextInfo())//描述
                .contact(new Contact("luyi", "", "640054794@qq.com"))//作者信息
                .license("The System Server, Version 1.0")//网站链接显示文字
                .build();

        return apiInfo;
    }

    private String initContextInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("用户服务API 提供了对用户的注册，查询，新增，修改，删除，批量删除接口");

        return sb.toString();
    }

    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * @return
     */
    @Bean
    public Docket restfulApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(initApiInfo())
                .groupName("RestfulApi")
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                 //暴露接口地址的包路径（即此包下的类，才生成接口文档）
                .apis(RequestHandlerSelectors.basePackage("com.luyi.user.controller"))
                .build();
    }


}

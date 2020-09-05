package com.company.project.configurer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2 // 启用 Swagger2
public class SwaggerConfig {

    @Value("${sys.version}")
    private String systemPublish;

    @Bean
    public Docket signApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SignAPI")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.project.commons.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("用户登录API")
                        .version(systemPublish)
                        .build());
    }

    @Bean
    public Docket messageApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("MessageAPI")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.project.message.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("聊天消息API")
                        .version(systemPublish)
                        .build());
    }

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("UserAPI")
                .pathMapping("/")
                .select()
                .paths(or(regex("/userInfo/.*")))//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("用户信息API")
                        .version(systemPublish)
                        .build());
    }

    @Bean
    public Docket tomatoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("TomatoAPI")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.project.tomato.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("番茄计划API")
                        .version(systemPublish)
                        .build());
    }

    @Bean
    public Docket noiseApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("NoiseAPI")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.project.noise.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("有益噪音API")
                        .version(systemPublish)
                        .build());
    }

    @Bean
    public Docket problemBookApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ProbleBookAPI")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.project.problembook.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("笔记本API")
                        .version(systemPublish)
                        .build());
    }

    @Bean
    public Docket questionPrizeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("QuestionPrizeAPI")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.project.questionprize.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("有奖问答API")
                        .version(systemPublish)
                        .build());
    }

    @Bean
    public Docket shopApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ShopAPI")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.project.shop.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("商店API")
                        .version(systemPublish)
                        .build());
    }

    @Bean
    public Docket studyHouseApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("StudyHouseAPI")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.project.studyhouse.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("学习屋API")
                        .version(systemPublish)
                        .build());
    }









    //    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                // 配置api扫描包的一个范围
//                .apis(RequestHandlerSelectors.basePackage("com.company.project"))
//                .paths(PathSelectors.any())
//                .build();
//    }


    /**
     * 创建文档信息
     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                // 文档标题
//                .title("api文档")
//                // 版本号
//                .version(systemPublish)
//                // 描述
//                .description("api文档")
//                .build();
//    }
}

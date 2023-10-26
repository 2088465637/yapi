package com.yuanchanglin.yapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author ycl
 * @since 2018-07-17
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    private static final String BASEPACKAGE = YapiApplication.class.getPackage().getName();

    /**
     * 不分模块用这个，分模块的话注释这个，取消注释下面的
     * @return

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASEPACKAGE))
                .paths(PathSelectors.any())
                .build();
    }
     */
    @Bean(name = "goodsApi")
    public Docket createRestApi1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASEPACKAGE+".goods"))
                .paths(PathSelectors.any())
                .build().groupName("商品模块");
    }
//    
//    @Bean(name = "systemApi")
//    public Docket createRestApi2() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(BASEPACKAGE+".user"))
//                .paths(PathSelectors.any())
//                .build().groupName("用户模块");
//    }
//    
//    @Bean(name = "repertoryApi")
//    public Docket createRestApi3() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(BASEPACKAGE+".repertory"))
//                .paths(PathSelectors.any())
//                .build().groupName("仓库模块");
//    }
//    
//    @Bean(name = "orderApi")
//    public Docket createRestApi4() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(BASEPACKAGE+".order"))
//                .paths(PathSelectors.any())
//                .build().groupName("订单模块");
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("XXX接口文档")
                .version("0.0.1")
                .build();
    }


}
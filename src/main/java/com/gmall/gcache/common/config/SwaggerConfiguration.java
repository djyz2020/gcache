package com.gmall.gcache.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
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

/**
 * Swagger文档，只有在测试环境才会使用
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfiguration {

	@Bean
	public Docket baseRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.gmall.cache.gcache.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Gcache项目接口文档")
				.description("Gcache项目接口文档Swagger版")
				.termsOfServiceUrl("")
				.contact(new Contact("深圳市福旺达电子商务有限公司", "", ""))
				.version("1.0")
				.build();
	}

}

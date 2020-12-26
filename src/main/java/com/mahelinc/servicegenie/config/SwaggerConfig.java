/**
 * This class is a Swagger Configuration.
 */
package com.mahelinc.servicegenie.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 *
 * @author surendrane
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	
	/**
	 * Product api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mahelinc.servicegenie.controller"))
				.paths(regex("/api/v1.*")).build().apiInfo(metaData());
	}

	/**
	 * Meta data.
	 *
	 * @return the api info
	 */
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Service Geni REST Services")
				.description("\"Service Initializers for Service Geni\"").version("1.0")
				.build();
	}

	/**
	 * Adds the resource handlers.
	 *
	 * @param registry the registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
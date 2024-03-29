package com.rabi.paymentservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class PaymentConfig {
	
	private String CONTROLLER_NAME="/paymentService.*";
	@Bean
	public Docket postApi() {
		
		return 
			new Docket(DocumentationType.SWAGGER_2)
			.groupName("Rabi world").apiInfo(apiInfo())
			.select().paths(regex(CONTROLLER_NAME)).build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Book Service111")
				.description("Sample Rabi Document#####")
				.termsOfServiceUrl("www.google.com")
				.license("Rabi License")
				.licenseUrl("www.google.com")
				.version("1.0")
				.build();
	}

}

package com.java.email.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json", "application/text"));

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api.*"), regex("/api.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("jaydip devkari").description("HSBC")
				.termsOfServiceUrl("Personal Account").contact("jay.android14@gmail.com")
				.license("Jay License").licenseUrl("jay.android14@gmail.com").version("1.0").build();
	}

}

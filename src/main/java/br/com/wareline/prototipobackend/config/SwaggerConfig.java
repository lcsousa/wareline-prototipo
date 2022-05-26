package br.com.wareline.prototipobackend.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
private final String PACKAGE_CONTROLLER="br.com.wareline.prototipobackend.controller";

	@Bean
	public Docket apiV1() {

		return new Docket(DocumentationType.SWAGGER_2).
				groupName("V1")
				.select()
				.apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROLLER))
				.paths(regex(".*/v1.*")).build().apiInfo(metaData("1.0"))
				.useDefaultResponseMessages(false)
				.securitySchemes(Arrays.asList(apiKey()))
		        .securityContexts(Arrays.asList(securityContext()));
	}

	@Bean
	public Docket apiV2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("V2")				
				.select()
				.apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROLLER))				
				.paths(regex(".*/v2.*")).build().apiInfo(metaData("2.0"))
				.useDefaultResponseMessages(false)
				.securitySchemes(Arrays.asList(apiKey()))
		        .securityContexts(Arrays.asList(securityContext()));
	}
	
	private ApiInfo metaData(String version) {
		return new ApiInfoBuilder().title("Wareline Protótipo API").description("Protótipo API REST")
				.version(version)
				.contact(new Contact("Wareline", "https://www.wareline.com.br/",
						""))
				.license("")
				.licenseUrl("https://www.wareline.com.br/").build();
	}
	
	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}
	private SecurityContext securityContext() {
	    return SecurityContext.builder()
	        .securityReferences(defaultAuth())
	        //.forPaths(PathSelectors.ant("/pessoa/**"))
	        .build();
	}
	
	List<SecurityReference> defaultAuth() {
	    AuthorizationScope authorizationScope
	        = new AuthorizationScope("global", "accessEverything");
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	    authorizationScopes[0] = authorizationScope;
	    return Arrays.asList(
	        new SecurityReference("JWT", authorizationScopes));
	}



}

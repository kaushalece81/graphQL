package com.example.swaggerdemoexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig implements WebMvcConfigurer
{

	// this method is added to resolve error
	//No mapping for GET /swagger-ui.html
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
	
	   @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build();
	    }
	
//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.swaggerdemoexample"))
//                .paths(regex("/rest.*"))
//                .build()
//                .apiInfo(metaData());
//    }
//    
//    private ApiInfo metaData() {
//        return new ApiInfoBuilder()
//                .title("Interface - Spring Boot Swagger Configuration")
//                .description("\"Swagger configuration for application \"")
//                .version("1.1.0")
//                .license("Apache 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//                .contact(new Contact("Interface", "kaushal", "kaushal@gamil.comm"))
//                .build();
//    }
}
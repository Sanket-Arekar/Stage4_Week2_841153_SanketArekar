package com.cognizant.movieservice;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class MovieServiceApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}
	public static final Contact DEFAULT_CONTACT = new Contact("Aakash Chaudhari", "", "aakash03chadhari@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Movie Service API", "Movie Service API Description", "1.0",
			"urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);

		// Now you will only find documentation for Movie Controller
		/*
		 * Test : http://localhost:8011/movie-service/swagger-ui.html
		 * http://localhost:8011/movie-service/v2/api-docs
		 */
	}

}

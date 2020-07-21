package com.cognizant.menuitemservice;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class MenuitemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuitemServiceApplication.class, args);
	}
	
	public static final Contact DEFAULT_CONTACT = new Contact("Aakash Chaudhari", "", "aakash03chadhari@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("MenuItem Service API", "MenuItem Service API Description", "1.0",
			"urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);

		// Now you will only find documentation for MenuItem Controller
		/*
		 * Test : http://localhost:<port_no>/menuitem-service/swagger-ui.html
		 * http://localhost:<port_no/menuitem-service/v2/api-docs
		 */
	}
}

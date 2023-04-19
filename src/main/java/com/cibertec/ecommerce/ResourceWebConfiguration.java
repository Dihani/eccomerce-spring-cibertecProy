package com.cibertec.ecommerce;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//implementa de interfaz WebMvcConfigurer
//agregamos notación @Configuration

@Configuration
public class ResourceWebConfiguration implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/imagenes/**").addResourceLocations("file:imagenes/");
	}
}

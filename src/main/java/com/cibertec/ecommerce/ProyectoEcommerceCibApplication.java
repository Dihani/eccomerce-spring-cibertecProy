package com.cibertec.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//colocar mientras no codificas lka nconexion a base de datos
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class ProyectoEcommerceCibApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoEcommerceCibApplication.class, args);
	}

}

package com.gruposuperior.calidad.manofactura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gruposuperior.calidad.manofactura")
public class ManofacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManofacturaApplication.class, args);
	}

}

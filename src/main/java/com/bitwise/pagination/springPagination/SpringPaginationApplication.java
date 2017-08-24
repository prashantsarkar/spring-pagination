package com.bitwise.pagination.springPagination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.bitwise.pagination" })
public class SpringPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPaginationApplication.class, args);
	}
}

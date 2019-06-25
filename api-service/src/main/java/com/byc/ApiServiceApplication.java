package com.byc;

import com.byc.filter.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplication.class, args);
	}

	@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r -> r.path("/customer/**")
						.filters(f -> f.filter(new MyFilter())
						.addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
						.uri("http://47.105.192.33:8080")
						.order(0)
						.id("customer_filter_router")
				)
				.build();
	}
}

package com.user.userapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class UserapplicationApplication {

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("UserCredentials"); // Define specific cache names if needed
	}

	public static void main(String[] args) {
		SpringApplication.run(UserapplicationApplication.class, args);
	}

}

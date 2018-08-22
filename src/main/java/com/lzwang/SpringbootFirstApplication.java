package com.lzwang;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * SpringBoot启动类
 */
@SpringBootApplication
@EnableCaching
public class SpringbootFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstApplication.class, args);
	}

	/**
	 * 测试 restTemplate消费rest服务
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner commandLineRunner(RestTemplate restTemplate) {
		return args -> {

			String quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
			System.out.printf(quote);
		};
	}

}

package com.anz.greenHouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GreenHouseApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(GreenHouseApplication.class, args);
	}

}

package com.training.mstmainte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.training.mstmainte.repository.BoardVO;

@SpringBootApplication
@EnableConfigurationProperties({
	BoardVO.class
})
public class MstmainteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MstmainteApplication.class, args);
	}

}

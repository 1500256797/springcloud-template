package cn.xxx.uaaserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.xxx.uaaserver.dao")
public class UaaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(UaaServerApplication.class, args);
	}

}

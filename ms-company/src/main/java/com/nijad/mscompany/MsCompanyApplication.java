package com.nijad.mscompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableSwagger2
public class MsCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCompanyApplication.class, args);
    }

}

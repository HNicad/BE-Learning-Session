package com.nijad.annotations;

import com.nijad.annotations.model.AMD;
import com.nijad.annotations.model.CPU;
import com.nijad.annotations.model.Computer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AnnotationsApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(AnnotationsApplication.class, args);
        Computer computer = ctx.getBean(Computer.class);
        System.out.println(computer.getCpu().getName());

    }
}

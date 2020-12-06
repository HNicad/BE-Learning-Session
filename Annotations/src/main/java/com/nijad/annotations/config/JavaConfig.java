package com.nijad.annotations.config;

import com.nijad.annotations.model.AMD;
import com.nijad.annotations.model.CPU;
import com.nijad.annotations.model.Computer;
import com.nijad.annotations.model.Intel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JavaConfig {
   @Bean
   @Primary
   public CPU getAmd(){
       return new AMD("AMD Ryzen 9","Quad-core");
   }
   @Bean
   public CPU getIntel(){
       return new Intel("Intel Core i9","Quad-core");
   }
   @Bean
   public Computer getComputer(@Qualifier("getIntel") CPU cpu){
       return new Computer(cpu);
   }
}

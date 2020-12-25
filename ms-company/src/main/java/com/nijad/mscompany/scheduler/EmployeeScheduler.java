package com.nijad.mscompany.scheduler;

import com.nijad.mscompany.model.EmployeeDto;
import com.nijad.mscompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeScheduler {
    static Logger logger = LoggerFactory.getLogger(EmployeeScheduler.class);
    private final EmployeeService employeeService;
    @Value("${message.happybirthday.boy}")
    private String messageForBoy;
    @Value("${message.happybirthday.girl}")
    private String messageForGirl;

    public EmployeeScheduler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    private boolean isBirthDate(LocalDate a){
        LocalDate b = LocalDate.now();
        return a.getMonth().equals(b.getMonth()) && a.getDayOfMonth() == b.getDayOfMonth();
    }
    @Scheduled(cron = "1 0 * * * ?")
    void sayHappyBirthday(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        employeeDtos.forEach(
                employeeDto -> {
                    if(isBirthDate(employeeDto.getBirthDate())){
                       if(employeeDto.isMale()){
                           logger.info(messageForBoy);
                       }else{
                           logger.info(messageForGirl);
                       }
                    }
                }
        );
    }
}

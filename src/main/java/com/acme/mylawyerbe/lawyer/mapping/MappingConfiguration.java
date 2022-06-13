package com.acme.mylawyerbe.lawyer.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("lawyerMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public  NotificationMapper notificationMapper() {return new NotificationMapper();}



}

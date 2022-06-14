package com.acme.mylawyerbe.lawyer.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("lawyerMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public AppointmentMapper appointmentMapper() {
        return new AppointmentMapper();
    }

    @Bean
    public FavouriteLawyerMapper favouriteLawyerResource(){return new FavouriteLawyerMapper();}
}

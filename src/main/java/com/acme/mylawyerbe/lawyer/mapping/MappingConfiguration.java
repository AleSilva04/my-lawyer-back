package com.acme.mylawyerbe.lawyer.mapping;

import com.acme.mylawyerbe.lawyer.mapping.LawyerMapper;
import com.acme.mylawyerbe.lawyer.mapping.LawyerSpecialtyMapper;
import com.acme.mylawyerbe.lawyer.mapping.SpecialtyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("lawyerMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public LawyerMapper lawyerMapper(){
        return new LawyerMapper();
    }

    @Bean
    public LawyerSpecialtyMapper lawyerSpecialtyMapper(){
        return new LawyerSpecialtyMapper();
    }

    @Bean
    public SpecialtyMapper specialtyMapper(){
        return new SpecialtyMapper();
    }
}

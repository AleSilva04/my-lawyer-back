package com.acme.mylawyerbe.lawyer.mapping;

import org.springframework.context.annotation.Configuration;

@Configuration("lawyerMappingConfiguration")
public class MappingConfiguration {

    public ClientMapper clientMapper(){
        return new ClientMapper();
    }

}

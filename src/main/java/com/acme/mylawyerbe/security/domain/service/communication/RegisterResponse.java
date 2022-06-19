package com.acme.mylawyerbe.security.domain.service.communication;

import com.acme.mylawyerbe.security.resource.UserResource;
import com.acme.mylawyerbe.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {

    //cuando es correcto el registro
    public RegisterResponse(UserResource resource){
        super(resource);
    }

    //cuando es incorrecto el registro
    public RegisterResponse(String message){
        super(message);
    }

}

package com.riwi.riwi.infraestructure.abstract_services;

import com.riwi.riwi.api.dto.request.UserReq;
import com.riwi.riwi.api.dto.response.UserResp;

public interface IUserService extends CrudUser<UserReq, UserResp, Long>{
    public final String FIELD_BY_SORT = "name";
}

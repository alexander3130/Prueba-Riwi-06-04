package com.riwi.riwi.infraestructure.abstract_services;


import com.riwi.riwi.api.dto.request.SurveyReq;
import com.riwi.riwi.api.dto.response.SurveyResp;

public interface ISurveyService extends CrudUser<SurveyReq, SurveyResp, Long>{
    
    public String FIELD_BY_SORT = "active";
    
}

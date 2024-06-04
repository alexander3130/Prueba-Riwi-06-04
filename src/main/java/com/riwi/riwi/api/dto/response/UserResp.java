package com.riwi.riwi.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserResp {
    private long id;
    private String name;
    private String email;
    private String password;
    private String active;
}

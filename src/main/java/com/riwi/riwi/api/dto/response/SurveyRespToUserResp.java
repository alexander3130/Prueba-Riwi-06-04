package com.riwi.riwi.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SurveyRespToUserResp {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean active;
}

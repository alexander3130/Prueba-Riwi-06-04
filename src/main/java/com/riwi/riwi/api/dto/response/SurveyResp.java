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

public class SurveyResp {
    private Long id;
    private LocalDateTime creation_date;
    private String description;
    private LocalDateTime dateTime;
    private String title;
    private boolean active;

}

package com.riwi.riwi.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SurveyReq {

    @NotBlank(message = "Especifique TRUE o FALSE para determinar si esta activo o no.")
    private boolean active;
    @NotBlank(message = "Hace falta una descripción.")
    private String description;
    @NotBlank(message = "Hace falta un titulo.")
    private String title;
    @NotNull(message = "Especifique la fecha y la hora.")
    @FutureOrPresent(message = "La fecha no puede ser inferior a la actual.")
    private LocalDateTime creation_date;
    @NotNull(message = "Especifique el usuario que creo la encuesta.")
    private Long creator_id;
}

package com.riwi.riwi.api.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserReq {
    @NotBlank(message = "Especifique un nombre.")
    private String name;
    @Email(message = "El correo electrónico no es válida.")
    @Size(min = 5, max = 100, message = "El email debe tener entre 5 y 100 caracteres.")
    private String email;
    @Size(min = 8, max = 100, message = "La contraseña debe tener 8 o mas caracteres.")
    private String password;
    private boolean active;

}

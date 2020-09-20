package com.bogdanov.project.client_hospital_admission.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public  class AuthenticationResponseDTO {
    private String email;
    private String token;
}
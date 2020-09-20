package com.bogdanov.project.client_hospital_admission.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthenticationRequestDTO {
    private String email;
    private String password;
}

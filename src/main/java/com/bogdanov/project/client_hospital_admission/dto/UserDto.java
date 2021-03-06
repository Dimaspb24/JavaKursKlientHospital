package com.bogdanov.project.client_hospital_admission.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    private Long id;
    @NonNull
    private String email;

    private String password;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    private String role;

    private String status;
}

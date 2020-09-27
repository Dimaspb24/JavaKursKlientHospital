package com.bogdanov.project.client_hospital_admission.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonDto {

    private Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String patherName;
    @NonNull
    private String diagnosisName;
    @NonNull
    private String wardName;

}

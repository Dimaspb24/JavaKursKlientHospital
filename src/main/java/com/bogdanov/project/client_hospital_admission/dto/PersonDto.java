package com.bogdanov.project.client_hospital_admission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class PersonDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String patherName;

    private String diagnosisName;

    private String wardName;

}

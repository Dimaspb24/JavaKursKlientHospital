package com.bogdanov.project.client_hospital_admission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class DiagnosisDto {

    private Long id;

    private String name;

//    private Set<PersonDto> persons;
}

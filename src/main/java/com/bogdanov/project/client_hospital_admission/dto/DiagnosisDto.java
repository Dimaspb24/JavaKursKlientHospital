package com.bogdanov.project.client_hospital_admission.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DiagnosisDto {
    private Long id;

    @NonNull
    private String name;

//    private Set<PersonDto> persons;
}

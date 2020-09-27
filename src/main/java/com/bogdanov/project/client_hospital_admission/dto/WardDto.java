package com.bogdanov.project.client_hospital_admission.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WardDto {
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private Integer maxCount;

//    private Set<PersonDto> persons;
}

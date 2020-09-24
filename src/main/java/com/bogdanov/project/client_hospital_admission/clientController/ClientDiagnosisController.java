package com.bogdanov.project.client_hospital_admission.clientController;

import com.bogdanov.project.client_hospital_admission.dto.DiagnosisDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping
public class ClientDiagnosisController {


    @GetMapping("/diagnoses")
    public String findAllDiagnoses(@RequestParam(required = false) String filter, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url;
        ResponseEntity<Object> responseEntity;

        if (filter != null && !filter.isEmpty()) {
            url = "http://localhost:8080/api/v1/diagnoses/find/".concat(filter);
            responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);
            model.addAttribute("filter", filter);
        } else {
            url = "http://localhost:8080/api/v1/diagnoses";
            responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);
        }

        List<DiagnosisDto> diagnoses = (List<DiagnosisDto>) responseEntity.getBody();
        model.addAttribute("diagnosesList", diagnoses);
        return "diagnoses";
    }

    @PostMapping("/diagnoses/save")
    public String saveDiagnosis(@RequestParam String name) {
        DiagnosisDto diagnosis = new DiagnosisDto(name);
        HttpEntity<DiagnosisDto> httpEntity = new HttpEntity<>(diagnosis, ClientAuthController.getHttpHeaderWithToken());
        String url = "http://localhost:8080/api/v1/diagnoses";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, httpEntity, Object.class);

//        Здесь возникает ошибка:
//        LinkedHashMap cannot be cast to class com.bogdanov.project.client_hospital_admission.dto.DiagnosisDto
//        DiagnosisDto diagnosisDto = (DiagnosisDto) responseEntity.getBody();
        return "redirect:/diagnoses";
    }

    // Робит или нет?
//    @GetMapping("/diagnoses/{id}")
//    public String findDiagnosisById(@PathVariable Long id, Map<String, Object> model) {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/api/v1/diagnoses/".concat(String.valueOf(id));
//        ResponseEntity<Object> responseEntity = restTemplate.exchange(
//                url, HttpMethod.GET, getHttpEntityWithToken(), Object.class);
//        DiagnosisDto diagnosis = (DiagnosisDto) responseEntity.getBody();
//
//        model.put("diagnoses", diagnosis);
//        return "diagnoses";
//    }
}

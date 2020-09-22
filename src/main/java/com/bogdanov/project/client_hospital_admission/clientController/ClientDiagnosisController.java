package com.bogdanov.project.client_hospital_admission.clientController;

import com.bogdanov.project.client_hospital_admission.dto.DiagnosisDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class ClientDiagnosisController {

    public HttpEntity<String> getHttpEntityWithToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, ClientAuthController.getToken());
        return new HttpEntity<>(headers);
    }

    public HttpHeaders getHttpHeaderWithToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, ClientAuthController.getToken());
        return headers;
    }

    @GetMapping("/diagnoses")
    public String findAllDiagnoses(@RequestParam(required = false) String filter, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "";

        if (filter != null && !filter.isEmpty()) {
            url = "http://localhost:8080/api/v1/diagnoses/find/".concat(filter);
            ResponseEntity<Object> responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, getHttpEntityWithToken(), Object.class);

            List<DiagnosisDto> diagnosis = (List<DiagnosisDto>) responseEntity.getBody();
            model.addAttribute("diagnosesList", diagnosis);
//            model.addAttribute("filter", filter);
        } else {

            url = "http://localhost:8080/api/v1/diagnoses";

            ResponseEntity<Object> responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, getHttpEntityWithToken(), Object.class);
            HashMap<String, Object> map = (HashMap<String, Object>) responseEntity.getBody();
//            String mail = (String) map.get("user");
            List<DiagnosisDto> diagnoses = (List<DiagnosisDto>) map.get("diagnoses");

//            model.addAttribute("user", mail);
            model.addAttribute("diagnosesList", diagnoses);
        }
        return "diagnoses";
    }

    @PostMapping("/diagnoses/save")
    public String saveDiagnosis(@RequestParam String name) {
        DiagnosisDto diagnosis = new DiagnosisDto(name);
        HttpEntity<DiagnosisDto> httpEntity = new HttpEntity<>(diagnosis, getHttpHeaderWithToken());
        String url = "http://localhost:8080/api/v1/diagnoses";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, httpEntity, Object.class);

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

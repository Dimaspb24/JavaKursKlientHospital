package com.bogdanov.project.client_hospital_admission.clientController;

import com.bogdanov.project.client_hospital_admission.dto.DiagnosisDto;
import com.bogdanov.project.client_hospital_admission.dto.PersonDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/diagnoses")
public class ClientDiagnosisController {

    @GetMapping
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
        model.addAttribute("diagnoses", diagnoses);

        if (ClientAuthController.getRole().equals("ADMIN")) {
            return "diagnoses";
        } else {
            return "diagnosesForUser";
        }
    }

    @PostMapping("/save")
    public String saveOrUpdateDiagnosis(@RequestParam Map<String, String> form) {
        Long id = (form.get("id") == null) ? null : Long.parseLong(form.get("id"));
        DiagnosisDto diagnosis = new DiagnosisDto(id, form.get("name"));
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


    @PostMapping("/{id}")
    public String deleteDiagnosisById(@PathVariable Long id, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/diagnoses/".concat(String.valueOf(id));
        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, ClientAuthController.getHttpEntityWithToken(), Object.class);

        List<PersonDto> dependentPersons = (List<PersonDto>) responseEntity.getBody();
        if (dependentPersons == null || dependentPersons.isEmpty()) {
            return "redirect:/diagnoses";
        } else {
            model.addAttribute("persons", dependentPersons);
            return "persons";
        }
    }

    @GetMapping("{id}")
    public String diagnosisEditForm(@PathVariable String id, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/diagnoses/".concat(id);

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);
//        Почему здесь нельзя собрать класс

        LinkedHashMap<?, ?> diagnosis = (LinkedHashMap<?, ?>) responseEntity.getBody();

        model.addAttribute("diagnosis", diagnosis);
        return "diagnosisEdit";
    }
}

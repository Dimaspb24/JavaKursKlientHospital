package com.bogdanov.project.client_hospital_admission.clientController;

import com.bogdanov.project.client_hospital_admission.dto.DiagnosisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class ClientDiagnosisController {

    public HttpEntity<String> getHttpEntityWithToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, Sign.getToken());
        return new HttpEntity<>("parameters", headers);

    }

    @GetMapping("/diagnoses")
    public String findAllPersons(Map<String, Object> model) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api/v1/diagnoses";
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, getHttpEntityWithToken(), Object.class);
        List<DiagnosisDto> diagnoses = (List<DiagnosisDto>) responseEntity.getBody();

        model.put("diagnoses", diagnoses);
        return "diagnoses";
    }

//    @GetMapping("/diagnoses/{id}")
//    public String findPersonById(@PathVariable Long id, Map<String, Object> model) {
//        Diagnosis diagnosis = diagnosisService.findById(id);
//        model.put("diagnoses", diagnosis);
//        return "diagnoses";
//    }
//
//    @PostMapping("/diagnoses")
//    public String savePerson(@RequestParam String name) {
//        Diagnosis diagnosis = new Diagnosis(name, null);
//        diagnosisService.saveDiagnosis(diagnosis);
//        return "redirect:/diagnoses";
//    }
//
//    @PostMapping("/diagnoses/filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model) {
//        List<Diagnosis> diagnoses;
//
//        if (filter != null && !filter.isEmpty()) {
//            diagnoses = diagnosisService.findByName(filter);
//            model.put("diagnoses", diagnoses);
//            return "/diagnoses";
//        } else {
//            return "redirect:/diagnoses";
//        }
//    }

}

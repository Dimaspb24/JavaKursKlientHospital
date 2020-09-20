package com.bogdanov.project.client_hospital_admission.clientController;

import com.bogdanov.project.client_hospital_admission.dto.AuthenticationRequestDTO;
import com.bogdanov.project.client_hospital_admission.dto.DiagnosisDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class SignIn {

    public static String token;

    @PostMapping("/login")
    public String login(@RequestParam String email,
                      @RequestParam String password,
                      Map<String, Object> model) {

        RestTemplate restTemplate = new RestTemplate();

        AuthenticationRequestDTO requestDTO = new AuthenticationRequestDTO(email, password);
        HttpEntity<AuthenticationRequestDTO> bodyHead = new HttpEntity<>(requestDTO);
        String urlAuth = "http://localhost:8080/api/v1/auth/login";

        ResponseEntity<Object> response = restTemplate.exchange(urlAuth, HttpMethod.POST, bodyHead, Object.class);

        Map<Object, Object> responseBody = (Map<Object, Object>) response.getBody();
        token = String.valueOf(responseBody.get("token"));

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = "http://localhost:8080/api/v1/diagnoses";
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,  Object.class);
        List<DiagnosisDto> body = (List<DiagnosisDto>) responseEntity.getBody();

        model.put("diagnoses", body);

        return "main";
    }

    @PostMapping("/logout")
    public String logout() {
        token = null;
        return "login";
    }
}

package com.bogdanov.project.client_hospital_admission.clientController;

import com.bogdanov.project.client_hospital_admission.dto.AuthenticationRequestDTO;
import com.bogdanov.project.client_hospital_admission.dto.UserDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
@RequestMapping("/auth")
public class Sign {

    public static String token;

    public static String getToken() {
        return token;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                      @RequestParam String password,
                      Map<String, Object> model) {

        RestTemplate restTemplate = new RestTemplate();

        AuthenticationRequestDTO requestDTO = new AuthenticationRequestDTO(email, password);
        HttpEntity<AuthenticationRequestDTO> body = new HttpEntity<>(requestDTO);
        String urlAuth = "http://localhost:8080/api/v1/auth/login";

        ResponseEntity<Object> response = restTemplate.exchange(urlAuth, HttpMethod.POST, body, Object.class);

        Map<Object, Object> responseBody = (Map<Object, Object>) response.getBody();
        token = String.valueOf(responseBody.get("token"));

        return "main";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               Map<String, Object> model){

        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = new UserDto(email, password, firstName, lastName);
        HttpEntity<UserDto> body = new HttpEntity<>(userDto);
        String url = "http://localhost:8080/api/v1/auth/registration";
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, body, Object.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return "login";
        } else {
            return "redirect:/registration";
        }
    }

    @PostMapping("/logout")
    public String logout() {
        token = null;
        return "login";
    }
}

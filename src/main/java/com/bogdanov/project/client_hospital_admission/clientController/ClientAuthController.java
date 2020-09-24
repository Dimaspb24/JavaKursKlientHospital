package com.bogdanov.project.client_hospital_admission.clientController;

import com.bogdanov.project.client_hospital_admission.dto.AuthenticationRequestDto;
import com.bogdanov.project.client_hospital_admission.dto.UserDto;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
@RequestMapping("/auth")
public class ClientAuthController {

    public static String token;
    public static String email;

    public static String getEmail() {
        return email;
    }

    public static String getToken() {
        return token;
    }

    public static HttpEntity<String> getHttpEntityWithToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, ClientAuthController.getToken());
        return new HttpEntity<>(headers);
    }

    public static HttpHeaders getHttpHeaderWithToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, ClientAuthController.getToken());
        return headers;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {

        RestTemplate restTemplate = new RestTemplate();

        AuthenticationRequestDto requestDTO = new AuthenticationRequestDto(email, password);
        HttpEntity<AuthenticationRequestDto> body = new HttpEntity<>(requestDTO);
        String urlAuth = "http://localhost:8080/api/v1/auth/login";

        ResponseEntity<Object> response = restTemplate.exchange(urlAuth, HttpMethod.POST, body, Object.class);

        Map<Object, Object> responseBody = (Map<Object, Object>) response.getBody();
        token = String.valueOf(responseBody.get("token"));
        email = String.valueOf(responseBody.get("email"));

        model.addAttribute("email", email);
        return "main";
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("email", email);
        return "main";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               Model model) {

        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = new UserDto(email, password, firstName, lastName);
        HttpEntity<UserDto> body = new HttpEntity<>(userDto);
        String url = "http://localhost:8080/api/v1/auth/registration";
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, body, Object.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return "login";
        } else {
            model.addAttribute("message", "Неправильные данные");
            return "registration";
        }
    }

    @PostMapping("/logout")
    public String logout(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api/v1/auth/logout";
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, getHttpEntityWithToken(), Object.class);
        token = null;
        email = null;
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return "login";
        } else {
            throw new RuntimeException("Error of logout");
        }
    }
}

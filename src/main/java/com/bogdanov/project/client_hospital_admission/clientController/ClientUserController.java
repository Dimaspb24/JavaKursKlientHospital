package com.bogdanov.project.client_hospital_admission.clientController;

import com.bogdanov.project.client_hospital_admission.dto.UserDto;
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
@RequestMapping("users")
public class ClientUserController {

    @GetMapping
    public String userList(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/users";

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);

        List<UserDto> users = (List<UserDto>) responseEntity.getBody();

        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("{email}")
    public String userEditForm(@PathVariable String email, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/users/".concat(email);

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);
//        Почему здесь нельзя собрать класс
//        UserDto user = (UserDto) responseEntity.getBody();
        LinkedHashMap<?, ?> user = (LinkedHashMap<?, ?>) responseEntity.getBody();

        model.addAttribute("user", user);
        return "userEdit";
    }

    //    @RequestParam Map<String, String> form
    @PostMapping
    public String userSave(@RequestParam Map<String, String> form) {

        UserDto userDto = new UserDto(null,
                form.get("email"),
                form.get("password"),
                form.get("firstName"),
                form.get("lastName"),
                form.get("role"),
                form.get("status"));

        HttpEntity<UserDto> httpEntity = new HttpEntity<>(userDto, ClientAuthController.getHttpHeaderWithToken());

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/users";

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, httpEntity, Object.class);

        return "redirect:/users";
    }

    @PostMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/users/".concat(String.valueOf(id));
        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, ClientAuthController.getHttpEntityWithToken(), Object.class);
        return "redirect:/users";
    }
}

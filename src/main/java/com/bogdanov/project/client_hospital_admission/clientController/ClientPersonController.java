package com.bogdanov.project.client_hospital_admission.clientController;

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
@RequestMapping("/persons")
public class ClientPersonController {

    @GetMapping
    public String findAllPersons(@RequestParam(required = false) String filter, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url;
        ResponseEntity<Object> responseEntity;

        if (filter != null && !filter.isEmpty()) {
            url = "http://localhost:8080/api/v1/persons/find/".concat(filter);
            responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);
            model.addAttribute("filter", filter);
        } else {
            url = "http://localhost:8080/api/v1/persons";
            responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);
        }

        List<PersonDto> persons = (List<PersonDto>) responseEntity.getBody();
        model.addAttribute("persons", persons);
        return "persons";
    }

    //    пока задействовано только сохранение
    @PostMapping("/save")
    public String saveOrUpdateWard(@RequestParam Map<String, String> form) {
        Long id = (form.get("id") == null) ? null : Long.parseLong(form.get("id"));
        PersonDto ward = new PersonDto(id,
                form.get("firstName"),
                form.get("lastName"),
                form.get("patherName"),
                form.get("diagnosisName"),
                form.get("wardName"));
        HttpEntity<PersonDto> httpEntity = new HttpEntity<>(ward, ClientAuthController.getHttpHeaderWithToken());
        String url = "http://localhost:8080/api/v1/persons";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, httpEntity, Object.class);

        return "redirect:/persons";
    }

    @PostMapping("/{id}")
    public String deletePersonById(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/persons/".concat(String.valueOf(id));
        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, ClientAuthController.getHttpEntityWithToken(), Object.class);
        return "redirect:/persons";
    }

    @GetMapping("{id}")
    public String personEditForm(@PathVariable String id, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/persons/".concat(id);

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);
//        Почему здесь нельзя собрать класс

        LinkedHashMap<?, ?> person = (LinkedHashMap<?, ?>) responseEntity.getBody();

        model.addAttribute("person", person);
        return "personEdit";
    }
}

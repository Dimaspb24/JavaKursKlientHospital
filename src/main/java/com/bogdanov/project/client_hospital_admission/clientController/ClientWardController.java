package com.bogdanov.project.client_hospital_admission.clientController;

import com.bogdanov.project.client_hospital_admission.dto.WardDto;
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
@RequestMapping("/wards")
public class ClientWardController {

    @GetMapping
    public String findAllWards(@RequestParam(required = false) String filter, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url;
        ResponseEntity<Object> responseEntity;

        if (filter != null && !filter.isEmpty()) {
            url = "http://localhost:8080/api/v1/wards/find/".concat(filter);
            responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);
            model.addAttribute("filter", filter);
        } else {
            url = "http://localhost:8080/api/v1/wards";
            responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);
        }

        List<WardDto> wards = (List<WardDto>) responseEntity.getBody();
        model.addAttribute("wards", wards);
        return "wards";
    }

    //    пока задействовано только сохранение

    //    @RequestParam String name, @RequestParam int maxCount
    @PostMapping("/save")
    public String saveOrUpdateWard(@RequestParam Map<String, String> form) {
        Long id = (form.get("id") == null) ? null : Long.parseLong(form.get("id"));
        WardDto ward = new WardDto(id, form.get("name"), Integer.valueOf(form.get("maxCount")));
        HttpEntity<WardDto> httpEntity = new HttpEntity<>(ward, ClientAuthController.getHttpHeaderWithToken());
        String url = "http://localhost:8080/api/v1/wards";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, httpEntity, Object.class);

        return "redirect:/wards";
    }

    @PostMapping("/{id}")
    public String deleteWardById(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/wards/".concat(String.valueOf(id));
        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, ClientAuthController.getHttpEntityWithToken(), Object.class);
        return "redirect:/wards";
    }

    @GetMapping("{id}")
    public String wardEditForm(@PathVariable String id, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/wards/".concat(id);

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, ClientAuthController.getHttpEntityWithToken(), Object.class);
//        Почему здесь нельзя собрать класс

        LinkedHashMap<?, ?> ward = (LinkedHashMap<?, ?>) responseEntity.getBody();

        model.addAttribute("ward", ward);
        return "wardEdit";
    }
}

package com.bogdanov.project.client_hospital_admission.clientController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {

    @GetMapping
    public String getSignInPage() {
        return "login";
    }

    @GetMapping("registration")
    public String getSignUpPage(Model model) {
        model.addAttribute("message", "Введите свои пользовательские данные");
        return "registration";
    }
}

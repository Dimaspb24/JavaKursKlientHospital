package com.bogdanov.project.client_hospital_admission.clientController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {

    @GetMapping("login")
    public String getSignInPage() {
        return "login";
    }

    @GetMapping("registration")
    public String getSignUpPage() {
        return "registration";
    }

    @GetMapping
    public String getStartPage() {
        return "start";
    }
}

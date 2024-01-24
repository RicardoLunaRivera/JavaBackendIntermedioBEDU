package org.bedu.veterinaria.controllervistas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

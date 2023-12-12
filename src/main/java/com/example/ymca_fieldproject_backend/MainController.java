package com.example.ymca_fieldproject_backend;

import com.example.ymca_fieldproject_backend.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    // Home Page
    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }
}

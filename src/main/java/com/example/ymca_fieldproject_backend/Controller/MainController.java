package com.example.ymca_fieldproject_backend.Controller;

import com.example.ymca_fieldproject_backend.Model.UserRepository;
import com.example.ymca_fieldproject_backend.SearchEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.security.Principal;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    // Home Page
    @GetMapping("/")
    public String viewHomePage(Model model) {
        SearchEngine.setSearchText("");
        model.addAttribute("searchEngine", new SearchEngine());
        return "index";
    }

    @GetMapping("/index")
    public String viewTestPage(Model model) {
        SearchEngine.setSearchText("");
        model.addAttribute("searchEngine", new SearchEngine());
        return "index";
    }

    @GetMapping("/search")
    public String viewSearchPage(Model model) {
        model.addAttribute("searchEngine", new SearchEngine());
        return "search";
    }

    @PostMapping("/search")
    public String searchRequest(Model model, @ModelAttribute("searchEngine") SearchEngine searchEngine) throws IOException {
        return SearchEngine.performSearch(model);
    }
}

package com.example.ymca_fieldproject_backend;

import com.example.ymca_fieldproject_backend.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    // Home Page
    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/index")
    public String viewIndexPage() {
        return "index";
    }

    @GetMapping("/search")
    public String showSearchPage(Model model) {
        model.addAttribute("searchEngine", new SearchEngine());
        return "search";
    }

    @PostMapping("/search")
    public String searchRequest(Model model, @ModelAttribute("searchEngine") SearchEngine searchEngine) throws IOException {
        return SearchEngine.performSearch(model);
    }

    @GetMapping("/test")
    public String viewTestPage() {
        return "test";
    }

}

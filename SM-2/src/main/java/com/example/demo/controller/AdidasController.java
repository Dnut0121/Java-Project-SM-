package com.example.demo.controller;

import com.example.demo.entity.Adidas;
import com.example.demo.service.AdidasService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdidasController {

    @Autowired
    private AdidasService adidasService;

    @GetMapping("/adidas")
    public String adidasPage(HttpSession session, Model model) {
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        
        List<Adidas> shoes = adidasService.getAllShoes();
        model.addAttribute("shoes", shoes);
        
        return "adidas";
    }
}

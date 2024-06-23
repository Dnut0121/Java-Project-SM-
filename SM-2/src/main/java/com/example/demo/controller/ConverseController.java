package com.example.demo.controller;

import com.example.demo.entity.Converse;
import com.example.demo.service.ConverseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ConverseController {

    @Autowired
    private ConverseService converseService;

    @GetMapping("/converse")
    public String conversePage(HttpSession session, Model model) {
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        
        List<Converse> shoes = converseService.getAllShoes();
        model.addAttribute("shoes", shoes);
        
        return "converse";
    }
}

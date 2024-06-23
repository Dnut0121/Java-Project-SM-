package com.example.demo.controller;

import com.example.demo.entity.NB;
import com.example.demo.service.NBService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NBController {

    @Autowired
    private NBService nbService;

    @GetMapping("/nb")
    public String nbPage(HttpSession session, Model model) {
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        
        List<NB> shoes = nbService.getAllShoes();
        model.addAttribute("shoes", shoes);
        
        return "nb";
    }
}

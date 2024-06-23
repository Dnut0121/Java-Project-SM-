package com.example.demo.controller;

import com.example.demo.entity.Nike;
import com.example.demo.service.NikeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NikeController {

    @Autowired
    private NikeService nikeService;

    @GetMapping("/nike")
    public String nikePage(HttpSession session, Model model) {
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        
        List<Nike> shoes = nikeService.getAllShoes();
        model.addAttribute("shoes", shoes);
        
        return "nike";
    }
}

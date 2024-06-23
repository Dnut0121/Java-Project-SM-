package com.example.demo.controller;

import com.example.demo.dto.LoginDTO;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(LoginDTO loginDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        boolean isSuccess = userService.login(loginDTO, redirectAttributes, session);
        if (isSuccess) {
            redirectAttributes.addFlashAttribute("successMessage", "로그인 성공");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "index";
        }
    }
}

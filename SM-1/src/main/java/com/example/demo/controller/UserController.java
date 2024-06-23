package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserDTO userDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        if (!userDTO.getPassword().equals(userDTO.getPasswordConfirm())) {
            model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            return "signup";
        }

        userService.registerUser(userDTO);
        redirectAttributes.addFlashAttribute("successMessage", "회원가입에 성공하였습니다.");
        return "redirect:/";
    }
}

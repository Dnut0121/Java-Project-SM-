package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean isUsernameExists(String username) {
        User user = userDAO.getUserByUsername(username);
        return user != null;
    }

    @Transactional
    public void registerUser(UserDTO userDTO) {
        if (isUsernameExists(userDTO.getUsername())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setGrade(userDTO.getGrade());
        user.setLikes(userDTO.getLikes());

        userDAO.insertUser(user);
    }

    public List<User> getUserList() {
        return userDAO.getUserList();
    }

    public boolean login(@RequestBody LoginDTO loginDTO, RedirectAttributes redirectAttributes, HttpSession session) {
        User user = userDAO.getUserByUsername(loginDTO.getUsername());

        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
            // 로그인 성공
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("grade", user.getGrade());
            redirectAttributes.addFlashAttribute("message", "로그인 성공");
            return true;
        } else {
            // 로그인 실패
            redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return false;
        }
    }

    public User getCurrentUser(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            return userDAO.getUserById(userId);
        }
        return null;
    }
}

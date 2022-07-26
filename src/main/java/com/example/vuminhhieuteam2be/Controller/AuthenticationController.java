package com.example.vuminhhieuteam2be.Controller;

import com.example.vuminhhieuteam2be.Entity.UserEntity;
import com.example.vuminhhieuteam2be.Model.LoginModel;
import com.example.vuminhhieuteam2be.Model.RegisterModel;
import com.example.vuminhhieuteam2be.Model.UserModel;
import com.example.vuminhhieuteam2be.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AuthenticationController {
    @Autowired
    IUserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("user", new LoginModel());
        return "login";
    }

    @GetMapping("/403")
    public String showError() {
        return "403";
    }

    @GetMapping("/signup")
    public String showSignup(Model model) {
        model.addAttribute("user", new RegisterModel());
        return "register";
    }
    @PostMapping("/sign-up")
    public String signUp(RegisterModel user, RedirectAttributes redirectAttributes) {
        UserEntity user1 = userService.findByUsername(user.getUsername());
        if (user1 == null) {
            UserEntity userEntity = new UserEntity();
            user.setUsername(user.getUsername());
            user.setEmail(user.getEmail());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.insertNew(UserModel.builder().email(user.getEmail()).username(user.getUsername()).password(user.getPassword()).build());
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("msg", "Username da bi trung");
            return "redirect:/signup";
        }
    }
}

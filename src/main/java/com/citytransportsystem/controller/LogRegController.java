package com.citytransportsystem.controller;

import com.citytransportsystem.dto.User;
import com.citytransportsystem.service.UserManager;
import com.citytransportsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class LogRegController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/exit")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        request.getSession().invalidate();
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(String login, String password) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.authUser(login, password)) {
            modelAndView.setViewName("redirect:/home");
        }
        else{
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logoutPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registration(User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.checkUnique(user)){
            userService.regUser(user);
        }
        return modelAndView;
    }
}
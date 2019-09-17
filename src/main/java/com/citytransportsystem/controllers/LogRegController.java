package com.citytransportsystem.controllers;

import com.citytransportsystem.dto.User;
import com.citytransportsystem.services.UserManager;
import com.citytransportsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

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
    public ModelAndView login(Long idUser, String password) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.authUser(idUser, password)) {
            modelAndView.setViewName("redirect:/main");
        }
        else{
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registrationPage(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
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
package com.citytransportsystem.controllers;

import com.citytransportsystem.dto.DB.UserDB;
import com.citytransportsystem.services.UserManager;
import com.citytransportsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

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
        UserDB currentUserDB = userService.checkUser(idUser, password);
//        if (currentUserDB != null) {
//            userManager.setUserDB(currentUserDB);
//            modelAndView.setViewName("redirect:/main");
//            modelAndView.addObject("user", currentUserDB);
//        } else {
//            modelAndView.setViewName("login");
//            modelAndView.addObject("errorMsg", "Логин/Пароль неверен");
//        }
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registrationPage(UserDB userDB) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registration(Long idUser, String fullName, LocalDate birthday, String position, Long contractId) {
        ModelAndView modelAndView = new ModelAndView();
        UserDB userDB = new UserDB(idUser, fullName, birthday, position, contractId);

        //TODO убрать в userService
        if (userService.getById(userDB.getId()) == null){
            userService.regUser(userDB);
        } else {
            modelAndView.addObject("errorMsg", "Пользователь с таким ID уже существует");
        }

        return modelAndView;
    }
}
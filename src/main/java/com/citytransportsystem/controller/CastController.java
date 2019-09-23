package com.citytransportsystem.controller;

import com.citytransportsystem.dto.Cast;
import com.citytransportsystem.dto.DB.CastDB;
import com.citytransportsystem.service.CastService;
import com.citytransportsystem.service.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("home")
public class CastController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private CastService castService;

    @GetMapping
    ModelAndView getHome(ModelAndView modelAndView){
        modelAndView.setViewName("home");
        List<Cast> casts = castService.getCastByUser(userManager.getUser());
        modelAndView.addObject(casts);
        return modelAndView;
    }

    @GetMapping("/add")
    ModelAndView getCastAdd(ModelAndView modelAndView){
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @PostMapping("/add")
    ModelAndView getCast(ModelAndView modelAndView, @Validated CastDB cast){
        modelAndView.setViewName("redirect:/home");
        castService.insert(cast);
        return modelAndView;
    }
}

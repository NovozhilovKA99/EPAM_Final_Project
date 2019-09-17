package com.citytransportsystem.controllers;

import com.citytransportsystem.dto.Cast;
import com.citytransportsystem.dto.DB.CastDB;
import com.citytransportsystem.services.CastService;
import com.citytransportsystem.services.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    ModelAndView getCast(ModelAndView modelAndView, CastDB cast){
        modelAndView.setViewName("redirect:/home");
        castService.insert(cast);
        //Comment
        return modelAndView;
    }
}

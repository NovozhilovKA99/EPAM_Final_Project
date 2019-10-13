package com.citytransportsystem.controller;

import com.citytransportsystem.dto.Cast;
import com.citytransportsystem.dto.DB.CastDB;
import com.citytransportsystem.exception.RouteException;
import com.citytransportsystem.exception.TransportException;
import com.citytransportsystem.exception.UserException;
import com.citytransportsystem.service.CastService;
import com.citytransportsystem.service.UserManager;
import jdk.jshell.spi.ExecutionControl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
        modelAndView.addObject("casts", casts);
        modelAndView.addObject("user", userManager.getUser());
        return modelAndView;
    }

    @GetMapping("/add")
    ModelAndView getCastAdd(ModelAndView modelAndView){
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @PostMapping("/add")
    ModelAndView getCast(ModelAndView modelAndView, @Validated CastDB cast, BindingResult result){
        modelAndView.setViewName("add");
        if(result.hasErrors()) {
            modelAndView.addObject("errorMsg", result.getAllErrors());
        }else{
            try {
                castService.insert(cast);
            }
            catch (UserException | TransportException | RouteException exc){
                modelAndView.addObject("excMsg", exc.getMessage());
                return modelAndView;
            }
            modelAndView.addObject("excMsg", "Успешно добавлено");
        }
        return modelAndView;
    }
}

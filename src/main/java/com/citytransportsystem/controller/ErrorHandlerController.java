package com.citytransportsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleRuntimeException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message", "Вы встретили редкую страницу," +
                " обратитесь в тех поддержку чтобы поймать ее");
        modelAndView.addObject("error", ex.getMessage());
        return modelAndView;
    }
}

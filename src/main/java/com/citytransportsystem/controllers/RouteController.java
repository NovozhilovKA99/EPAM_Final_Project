package com.citytransportsystem.controllers;

import com.citytransportsystem.dto.DB.RouteDB;
import com.citytransportsystem.dto.Stop;
import com.citytransportsystem.services.PositionService;
import com.citytransportsystem.services.RouteService;
import com.citytransportsystem.services.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("route")
public class RouteController {

    @Autowired
    PositionService positionService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private StopService stopService;

    @GetMapping
    public ModelAndView getRoute(ModelAndView modelAndView){
        modelAndView.setViewName("route");
        List<RouteDB> routes = routeService.getAllRoutes();
        modelAndView.addObject("routes", routes);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getRoute(ModelAndView modelAndView, @PathVariable Long id){
        modelAndView.setViewName("id");
        List<Stop> route = stopService.getStopsByRouteId(id);
        List<Stop> routeForward = new ArrayList<Stop>();
        List<Stop> routeBack = new ArrayList<Stop>();
        Boolean back = false;
        for (Stop stop : route){
            if (!back){
                routeForward.add(stop);
                back = back || stop.isEnd();
            }
            else{
                routeBack.add(stop);
            }
        }
        modelAndView.addObject("routeForward", routeForward);
        modelAndView.addObject("routeBack", routeBack);
        return modelAndView;
    }
}

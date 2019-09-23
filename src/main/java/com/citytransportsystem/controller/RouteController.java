package com.citytransportsystem.controller;

import com.citytransportsystem.dto.DB.RouteDB;
import com.citytransportsystem.dto.Stop;
import com.citytransportsystem.dto.Transport;
import com.citytransportsystem.service.PositionService;
import com.citytransportsystem.service.RouteService;
import com.citytransportsystem.service.StopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
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
        Map<Stop, Transport> transportList = positionService.getOnRoute(id);
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
        modelAndView.addObject("transport", transportList);
        return modelAndView;
    }
}

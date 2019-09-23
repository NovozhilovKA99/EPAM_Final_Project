package com.citytransportsystem.Interseptor;

import com.citytransportsystem.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private UserManager userManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (userManager.authorised()) {
            response.sendRedirect("/login");
            return false;
        }
        return true;

    }
}

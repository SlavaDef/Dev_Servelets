package com.goIt.Core5.Auth;

import javax.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// класи фільтри потрібні для того щоб робити якусь перевірку юзерів перед виконанням сервелетів

//@WebFilter(value = "/api/*") // тут буквально реагуй на все що починається з api
public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req,
                            HttpServletResponse res,
                            FilterChain chain) throws IOException, ServletException {

        String authHeaderValue = req.getHeader("Authorization");

        if ("111".equals(authHeaderValue)) { // якщо хідер дорівнює Authorization
            chain.doFilter(req, res); // то все ок пропускаємо запит далі
        } else {
            res.setStatus(401);
            res.setContentType("application/json");
            res.getWriter().write("{\"Error\": \"Not authorized\"}"); // зробили json в ручну
            res.getWriter().close();
        }


    }
}

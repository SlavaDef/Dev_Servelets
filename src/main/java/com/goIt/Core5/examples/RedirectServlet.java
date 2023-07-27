package com.goIt.Core5.examples;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Redirect це перенаправлення сторінки(сайту)
//@WebServlet(value = "/search")
public class RedirectServlet extends HttpServlet { // пишемо сервелет для перенаправлення


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // нас цікивить тут обробка запиту

        String googleUrl = "https://www.google.com/search"; // є базовий url

        if(req.getParameterMap().containsKey("q")){
            String q = req.getParameterValues("q")[0]; // ніби взяли перший параметер
            googleUrl += "?q" + q; // і це буде повний урл куди ми хочемо перенаправити юзера

        }
        resp.sendRedirect(googleUrl); // куди хочемо перенаправити
    }
}

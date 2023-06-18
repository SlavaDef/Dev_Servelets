package com.goIt.Core5;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// імплементемо інтерфейс Servlet і реалізуємо його методи чи більш зручніше це
// унаслідуватися від HttpServlet в якого вже є всі корисні методи
// далі треба вказати анотацію @WebServlet і в ній шлях куди ми хочемо все обробляти
// також там допускаються url патерни value = "/hello/*./test"
// "/" тут буквально все що приходить сюди нас влаштовує

@WebServlet(value = "/hello")
public class HelloWorldServelet extends HttpServlet {

    // далі перевизначаємо один із методів (doGet) класу HttpServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // + встановлюємо хедер контент тайп тобто це хтмл в якомусь кодуванні

        resp.setContentType("text/html; charset=utf-8");

        resp.getWriter().write("<h1>Hello Servlets!</h1>"); // це ніби тіло відповіді
        resp.getWriter().close();
        // HttpServletRequest - це те що нам прийшло звідти можемо витягнути хедери, запити....
        // HttpServletResponse - це те куди ми записуємо відповіді
       
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Servelet init!");
    }

    // наступний єтап це потрібно все збілдити
}

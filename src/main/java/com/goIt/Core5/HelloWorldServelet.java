 package com.goIt.Core5;
/*
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

// імплементемо інтерфейс Servlet і реалізуємо його методи чи більш зручніше це
// унаслідуватися від HttpServlet в якого вже є всі корисні методи
// далі треба вказати анотацію @WebServlet і в ній шлях куди ми хочемо все обробляти
// також там допускаються url патерни value = "/hello/*./test"
// "/" тут буквально все що приходить сюди нас влаштовує

@WebServlet(value = "/*")
public class HelloWorldServelet extends HttpServlet {

    // далі перевизначаємо один із методів (doGet) класу HttpServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // + встановлюємо хедер контент тайп тобто це хтмл в якомусь кодуванні
        // зазвичай всі параметри зчитуються як рядки
        String name = req.getParameter("name");

        resp.setContentType("text/html; charset=utf-8");

        resp.getWriter().write("<h1>Hello ${name}!</h1>".replace("${name}", parseName(req))); // це ніби тіло відповіді
        // http://localhost:8080/Dev_Servelets/hello?name=Ivan відповідь  hello Ivan
        resp.getWriter().write("<br>Parametries</br>");
        resp.getWriter().write(getAllParameters(req));

        // + додаємо поточну дату і час
        resp.getWriter().write("<br>Time</br>"); // перенос рядка

        // далі отримуємо поточну дату форматуємо отриманний результат по нашому шаблону
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                "yyyy-MM-dd, HH:mm:ss"
        ));
        resp.getWriter().write(currentTime);

        resp.getWriter().write("<br>Headers</br>");
        resp.getWriter().write(getAllHeaders(req));

        // хідер оновлення це не дуже гарна практика
        // resp.setHeader("Refresh", "5"); // сторінка оновлюється кожні 5сек

        resp.getWriter().close();

        // HttpServletRequest - це те що нам прийшло звідти можемо витягнути хедери, запити....
        // HttpServletResponse - це те куди ми записуємо відповіді

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private String parseName(HttpServletRequest req) { // парс метод щоб не викидало помилку якщо не внисимо значень
        if (req.getParameterMap().containsKey("name")) {
            return req.getParameter("name");
        }
        return "unnamed";
    }

    private String getAllParameters(HttpServletRequest request) throws IOException {

        String contentType = request.getHeader("content-type");

        if("application/json".equals(contentType)){ // якщо це json то використовуємо один метод
            return getAllParametersGson(request);
        }else {
            return getAllParametersUrlEncoded(request);// якщо ні то старий метод
        }
    }

    // розширяємо програму для виведення якщо gson то парсимо його, якщо ні залишаємо попередній варіант
    private String getAllParametersGson(HttpServletRequest request) throws IOException {
        // читаємо тіло запиту
        String body = request.getReader()
                .lines()
                .collect(Collectors.joining("\n")); // склеювання рядків через перенос

        // тіло запиту перетворюємо в Map,String, String

        Map<String, String> params = new Gson().fromJson(body,
                TypeToken.getParameterized(Map.class, String.class, String.class).getType());

        return params // беремо параметри
                .entrySet().stream() // отримуємо Key і getValue
                .map(it -> it.getKey() + " = " + it.getValue()) // перетворюємо обьекти на рядки
                .collect(Collectors.joining("<br>")); // збираємо все через br

    }

    private String getAllParametersUrlEncoded(HttpServletRequest request) {
        StringJoiner joiner = new StringJoiner("<br>"); // <br> це перехід на наступний рядок
        // пробігаємось по всіх параметрах
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {  // поки ще є єлементи
            String parameterName = parameterNames.nextElement();
            // витягуємо всі значення
            String parametrValues = Arrays.toString(request.getParameterValues(parameterName));
            // далі склеюємо в один рядок
            joiner.add(parameterName + " = " + parametrValues);
        }

        return joiner.toString();
        // запрос
        // http://localhost:8080/Dev_Servelets/hello?a=Sidni&a=D&b=Tom&c=Jerry віддасть нам
        //
        // a = [Sidni, D]
        // b = [Tom]
        // c = [Jerry]
    }

    // пишимо метод щоб зібрати всі заголовки

    private String getAllHeaders(HttpServletRequest request) {

        StringJoiner joiner = new StringJoiner("<br>");
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);

            joiner.add(headerName + " " + headerValue);
        }
        return joiner.toString();

    }

    // наступний єтап це потрібно все збілдити
}
*/
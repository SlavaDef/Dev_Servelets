package com.goIt.Core5.timeleaf;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// задача шаблонізатора знайти спец вирази (<span th:text="${name}"></span>) і обробивши їх видати нам фінал текст
// <span th:text=" '[' + ${name} + ']' "></span>  - це  TeamLiafe вираз

//@WebServlet("/thymeleaf")
public class TeamLiafeController extends HttpServlet {
    private TemplateEngine engine; // створили двіжок темплейта
    // String separator = File.separator;
//String path = "C:" + separator+"Users"+separator+"Vyacheslav"+separator+"PROJECTS"+separator+
    // "Dev_Servelets"+separator+"templates";

// метод init() виконується один раз при створенні сервелету

    @Override
    public void init() throws ServletException { // це ідеальний метод для якихось налаштувань

        engine = new TemplateEngine(); // create TemplateEngine тепер можна його підконфігигувати
        // ніби треба вказати звідкіля брати файли з налаштуванням


        FileTemplateResolver resolver = new FileTemplateResolver();
        // щоб не було ерорів вказали абсолютний шлях до папки templates
        // директорія папки шаблонів місцезнаходження в корні самого проєкту
        resolver.setPrefix("C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\bin\\templates/"); // отказано в доступе
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setOrder(engine.getTemplateResolvers().size());
        resolver.setCacheable(false);
        engine.addTemplateResolver(resolver);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");


        Map<String, String[]> paramMep = req.getParameterMap();
        Map<String, Object> params = new LinkedHashMap<>();

        for (Map.Entry<String, String[]> keyValue : paramMep.entrySet()) {
            params.put(keyValue.getKey(), keyValue.getValue()[0]);
        }
        // метод вже з врайтером
        // "test" - назва файлу
        // resp.getWriter() - куди писати
        // в контекст додаємо параметри які приймають змінні
        Context simpleContext =
                //new Context(req.getLocale(), Map.of("name", "Some name"));

                new Context(req.getLocale(), Map.of("queryParams", params));

        engine.process("test", simpleContext, resp.getWriter()); // вже з врайтером
        resp.getWriter().close();
    }
}

// <h1> Hello, <span th:text="${name}"></span> </h1> - name це змінна

   /*  WebApplicationTemplateResolver resolver1 = new WebApplicationTemplateResolver(new IWebApplication() {
              @Override
              public boolean containsAttribute(String name) {
                  return false;
              }

              @Override
              public int getAttributeCount() {
                  return 0;
              }

              @Override
              public Set<String> getAllAttributeNames() {
                  return null;
              }

              @Override
              public Map<String, Object> getAttributeMap() {
                  return null;
              }

              @Override
              public Object getAttributeValue(String name) {
                  return null;
              }

              @Override
              public void setAttributeValue(String name, Object value) {

              }

              @Override
              public void removeAttribute(String name) {

              }

              @Override
              public boolean resourceExists(String path) {
                  return null;
              }

              @Override
              public InputStream getResourceAsStream(String path) {
                  return null;
              }
          });
    } */

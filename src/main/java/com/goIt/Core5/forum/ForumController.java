package com.goIt.Core5.forum;

import com.goIt.Core5.forum.command.CommandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.io.IOException;


@WebServlet("/forum/*") // сервлет буде працювати за цим запитом http://localhost:8080/Dev_Servelets/forum
public class ForumController extends HttpServlet {

    private TemplateEngine engine; // створили двіжок темплейта
    private CommandService commandService;

// метод init() виконується один раз при створенні сервелету

    @Override
    public void init() throws ServletException { // це ідеальний метод для якихось налаштувань

        engine = new TemplateEngine(); // create TemplateEngine тепер можна його підконфігигувати
        // ніби треба вказати звідкіля брати файли з налаштуванням


        FileTemplateResolver resolver = new FileTemplateResolver();
        // щоб не було ерорів вказали абсолютний шлях до папки templates
        // директорія папки шаблонів місцезнаходження в корні самого проєкту
        // не забути вказати місцеположення папки templates саме в Tomcat d bin
        resolver.setPrefix("C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\bin\\templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setOrder(engine.getTemplateResolvers().size());
        resolver.setCacheable(false);
        engine.addTemplateResolver(resolver);

        commandService = new CommandService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        commandService.process( req, resp, engine);
    }

}
 /*  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        // метод вже з врайтером
        // "test" - назва файлу
        // resp.getWriter() - куди писати
        // в контекст додаємо параметри які приймають змінні
        Context simpleContext =
                //new Context(req.getLocale(), Map.of("name", "Some name"));

                new Context(
                        req.getLocale(),
                        Map.of("messages", messageStorage.getAllMessage())
                );

        engine.process("forum", simpleContext, resp.getWriter()); // вже з врайтером
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getRequestURI().contains("delete")) { // якщо в запиті буде delete
            String id = req.getParameter("id");// виділяємо з нього id
            messageStorage.deleteById(id); // видаляємо все по id


        } else { // тут робимо як раніше
            // витягуємо параметр name
            String author = req.getParameter("author");
            String content = req.getParameter("content");
// зазвичай в тех завданні вказуються перевірки для параметрів на нуль чи кількість символів
            // далі робимо новий меседж і додаємо в нього ті параметри
            Message message = new Message();
            message.setAuthor(author);
            message.setContent(content);
            message.setId(UUID.randomUUID().toString()); // автогенерація

            messageStorage.add(message);
        }
        // далі перенаправлення на нову сторінку (forum)
        resp.sendRedirect("/Dev_Servelets/forum");
    }
}  */


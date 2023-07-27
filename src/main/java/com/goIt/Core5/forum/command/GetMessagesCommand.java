package com.goIt.Core5.forum.command;

import com.goIt.Core5.forum.InMemoryMessageStorage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class GetMessagesCommand implements Command{

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        resp.setContentType("text/html");

        // метод вже з врайтером
        // "test" - назва файлу
        // resp.getWriter() - куди писати
        // в контекст додаємо параметри які приймають змінні
        Context simpleContext =
                //new Context(req.getLocale(), Map.of("name", "Some name"));

                new Context(
                        req.getLocale(),
                        Map.of("messages", InMemoryMessageStorage.getInstanse().getAllMessages())
                );

        engine.process("forum", simpleContext, resp.getWriter()); // вже з врайтером
        resp.getWriter().close();
    }
    }


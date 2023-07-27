package com.goIt.Core5.forum.command;

import com.goIt.Core5.forum.InMemoryMessageStorage;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMassageCommand implements Command{
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String id = req.getParameter("id");// виділяємо з запиту  id
        InMemoryMessageStorage.getInstanse().deleteById(id); // видаляємо все по id
        resp.sendRedirect("/Dev_Servelets/forum");
    }
}

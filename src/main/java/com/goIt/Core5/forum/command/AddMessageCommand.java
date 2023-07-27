package com.goIt.Core5.forum.command;

import com.goIt.Core5.forum.InMemoryMessageStorage;
import com.goIt.Core5.forum.Message;
import org.thymeleaf.TemplateEngine;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class AddMessageCommand implements Command{
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {
        String author = req.getParameter("author");
        String content = req.getParameter("content");
// зазвичай в тех завданні вказуються перевірки для параметрів на нуль чи кількість символів
        // далі робимо новий меседж і додаємо в нього ті параметри
        Message message = new Message();
        message.setAuthor(author);
        message.setContent(content);
        message.setId(UUID.randomUUID().toString()); // автогенерація

        InMemoryMessageStorage.getInstanse().add(message);

    // далі перенаправлення на нову сторінку (forum)
        resp.sendRedirect("/Dev_Servelets/forum");
    }
}

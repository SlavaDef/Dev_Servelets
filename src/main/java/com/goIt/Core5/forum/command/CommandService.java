package com.goIt.Core5.forum.command;

import org.thymeleaf.TemplateEngine;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandService { // метод для команд


    private Map<String, Command> commands;

    // + конструктор де ми проініціалізуємо все що нам потрібно

    public CommandService() {
        commands = new HashMap<>();
        // рееструємо команду
        commands.put("GET /Dev_Servelets/forum",new GetMessagesCommand());
        // рееструємо команду видалення
        commands.put("POST /Dev_Servelets/forum/delete", new DeleteMassageCommand());

        commands.put("POST /Dev_Servelets/forum", new AddMessageCommand());
    }

   public void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException {

        String requestUri = req.getRequestURI(); // отримуємо відповідь
        String commandKey = req.getMethod() + " " + requestUri; // тут вирішуємо який запрос буде Get Put
        commands.get(commandKey).process(req, resp, engine);
    }
}

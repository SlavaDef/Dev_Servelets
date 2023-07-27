package com.goIt.Core5.forum.command;

import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command { // по перше визначаємо інтерфейс команд

    // метод також приймає шаблонізатор
    void process(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) throws IOException;



}

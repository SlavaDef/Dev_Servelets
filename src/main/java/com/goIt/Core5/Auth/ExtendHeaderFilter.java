package com.goIt.Core5.Auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/api/*") // фільтрів може бути декілька і більше
public class ExtendHeaderFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException, ServletException {
        res.setHeader("HelloHeader", "HelloHeaderValue");

        chain.doFilter(req, res); // створеться пару хідерів
    }
}

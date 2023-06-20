package com.goIt.Core5.Calc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

// калькулятор який буде рахувати через json
@WebServlet("/api/calc")
public class CalcServlet extends HttpServlet {

    private CalcServise calcServise; // сервіз для підрахунку

    @Override
    public void init() throws ServletException { // тут ініціалізуємо сервіс
        calcServise = new CalcServise();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // сервелет повинен прийняти порахувати і віддати
        // перетворюємо запит в нашу внутрішню модель

        CalcRequest calcRequest = mapToCalcRequest(req);
        CalcResponse calcResponse = calcServise.calculate(calcRequest);

        resp.setContentType("application/json");
        resp.getWriter().write(new Gson().toJson(calcResponse));
        resp.getWriter().close();


    }

    private CalcRequest mapToCalcRequest(HttpServletRequest request) throws IOException {

        String body = request.getReader()
                .lines()
                .collect(Collectors.joining("\n")); // склеювання рядків через перенос

        return new Gson().fromJson(body,CalcRequest.class);



    }


}

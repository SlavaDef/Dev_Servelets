package com.goIt.Core5.Calc;

public class CalcServise { // задача класу прийняти запит і повернути відповідь

    public CalcResponse calculate(CalcRequest request) {

        int resalt = 0;
        switch (request.getOperation()) {
            case "+" :
                resalt = request.getParam1() + request.getParam2();
                break;
            case "-" :
                resalt = request.getParam1() - request.getParam2();
                break;
            case "*" :
                resalt = request.getParam1() * request.getParam2();
                break;
            case "/" :
                resalt = request.getParam1() / request.getParam2();
                break;

        }

        CalcResponse response = new CalcResponse();
        response.setRequest(request);
        response.setResult(resalt);

        return response;
    }


}

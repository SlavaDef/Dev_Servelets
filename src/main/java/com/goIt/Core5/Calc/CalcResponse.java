package com.goIt.Core5.Calc;


import lombok.Data;

@Data
public class CalcResponse { // клас для відповіді

    private CalcRequest request;

    private int result;

}

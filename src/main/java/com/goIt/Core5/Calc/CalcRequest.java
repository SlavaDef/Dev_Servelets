package com.goIt.Core5.Calc;


import lombok.Data;

@Data
public class CalcRequest { // клас де поступає запит на обробку

    private String opperation;
    private int param1;
    private int param2;


}

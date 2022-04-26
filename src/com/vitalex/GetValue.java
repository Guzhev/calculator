package com.vitalex;

class GetValue {
    private String delimiter = "";

    public String[] getValue(String str){

        String[] value = str.trim().split(delimiter);
        if (value.length == 2){
            return value;
        }
        else if (value.length == 1){
            System.out.println("строка не является математической операцией ");
        }
        else {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *) ");
        }
        return null;
    }


    public boolean checkRoman(String val){
        String[] roman = {"C", "L", "X", "IX", "V", "IV", "I"};
        int[] dec = {100, 50, 10, 9, 5, 4, 1};
        int res = 0;
        for (int i = 0; i < dec.length; i++ ) {
            while (val.indexOf(roman[i]) == 0) {
                res += dec[i];
                val = val.replaceFirst(roman[i], "");
            }
        }
        //System.out.println("Результат " + res);
        return res > 0 && res <= 10 && val.trim().isEmpty();
    }


    public boolean checkArab(String val){
        try{

            if(Integer.parseInt(val) > 0 && Integer.parseInt(val) <= 10){
                return true;
            }
            else {
                return false;
            }
         }
        catch (NumberFormatException e){
            return false;
        }
    }


    public String romanResult(String romanValX, String romanValY){
        String[] roman = {"C", "L", "X", "IX", "V", "IV", "I"};
        int[] dec = {100, 50, 10, 9, 5, 4, 1};
        int x = 0, y = 0;
        int z = 0;
        String romanRes = "";

        for (int i = 0; i < dec.length; i++ ) {
            while (romanValX.indexOf(roman[i]) == 0) {
                x += dec[i];
                romanValX = romanValX.substring(1);
            }
        }
        for (int i = 0; i < dec.length; i++ ) {
            while (romanValY.indexOf(roman[i]) == 0) {
                y += dec[i];
                romanValY = romanValY.substring(1);
            }
        }
        switch (delimiter) {
            case "\\+" -> z = x + y;
            case "-" -> z = x - y;
            case "\\*" -> z = x * y;
            case "/" -> z = x / y;
        }

        if (z < 0 ){
            return "в римской системе нет отрицательных чисел";
        }
        for (int i = 0; i < dec.length; i++ ) {
            while (z >= dec[i]) {
                z -= dec[i];
                romanRes = romanRes + roman[i];
            }
        }

       // System.out.println("Результат - " + romanRes);
        return romanRes;
    }

    public String arabResult(String arabValX, String arabValY){
        int x =0,y = 0;
        int z = 0;
        try{
            x = Integer.parseInt(arabValX);
            y = Integer.parseInt(arabValY);
        }
        catch (NumberFormatException e){
            System.err.println("Строка не является числом!");
        }

        if (y == 0){
            return "Деление на ноль!";
        }

        switch (delimiter) {
             case "\\+" -> z = x + y;
             case "-" -> z = x - y;
             case "\\*" -> z = x * y;
             case "/" -> z = x / y;
        }

        return Integer.toString(z);



    }


    public void setDelimiter(String input){
        delimiter = input;
    }
}

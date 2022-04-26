package com.vitalex;

import java.util.Locale;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию:");
        String result = calc(sc.nextLine().toUpperCase(Locale.ROOT));
        System.out.println("Ответ - " + result);
        sc.close();
    }



    public static String calc(String input) {
        GetValue gv = new GetValue();
        gv.setDelimiter(getDelimiter(input));
        String[] value = gv.getValue(input);

        if (value == null){
            return "Повторите ввод";
        }

        if (gv.checkRoman(value[0]) && gv.checkRoman(value[1])){
            System.out.println("Оба значения римские!!!\n\n" );
            System.out.println(gv.romanResult(value[0], value[1]));

        }

        else if (gv.checkArab(value[0]) && gv.checkArab(value[1])){
            System.out.println("Оба значения арабские!!!");
            System.out.println(gv.arabResult(value[0], value[1]));

        }
        else if (gv.checkArab(value[0]) && gv.checkRoman(value[1]) || gv.checkArab(value[1]) && gv.checkRoman(value[0])){
            System.out.println("Вы ввели и арабские и римские значения!!!");

        }
        else {
            System.out.println("Значения должны быть в диапазоне от 1 до 10 или от I до X!!!");
        }

        return value[0] + value[1];
    }

    private static String getDelimiter(String in) {
        String retDelimiter = "";

        try{
            if (in.contains("+")){
                retDelimiter = "\\+";
            }
            else if (in.contains("-")){
                retDelimiter = "-";
            }
            else if (in.contains("*")){
                retDelimiter = "\\*";
            }
            else if (in.contains("/")){
                retDelimiter = "/";
            }
            else {
                retDelimiter = "";
            }

        }
        catch (Exception e){
            System.out.println("Исключение" + e);
        }
        return retDelimiter;
    }
}


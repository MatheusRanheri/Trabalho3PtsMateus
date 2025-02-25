package com.util;

import java.util.Scanner;

public class Teclado {

    public static String lerString(String mensagem){
        return inicializarTeclado(mensagem).next();
    }

    public static Integer lerInteiro(String mensagem){
        return inicializarTeclado(mensagem).nextInt();
    }

    public static Double lerDouble(String mensagem){
        return inicializarTeclado(mensagem).nextDouble();
    }

    private static Scanner inicializarTeclado(String mensagem){
        System.out.println(mensagem);
        return new Scanner(System.in);
    }
}

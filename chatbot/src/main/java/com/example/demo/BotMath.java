package com.example.demo;

import static com.example.demo.MainChatBot.scanner;

public class BotMath {
    public enum MathOperation {
        SOMAR("somar"), SUBTRAIR("subtrair"), MULTIPLICAR("multiplicar"), DIVIDIR("dividir");
        private final String operation;
        MathOperation(String op){
            this.operation = op;
        };

        public String get(){
            return this.operation;
        }
    }

    private String botName = "Marciano Mode Math:";

    private String action;

    public BotMath(String action) {
        this.action = action;
    }

    public void start() {
        System.out.printf("Olá meu nome é Marciano Math e eu faço operações matemáticas, como por exemplo: somar, subtrair, dividir e multiplicar, vamos começarar?\n");
        System.out.printf("Digite acao: ");

        String actionUser = scanner.nextLine();

        while (!actionUser.equals("FIM")) {
            try {
                MathOperation math = MathOperation.valueOf(actionUser.toUpperCase());
                switch (math){
                    case SOMAR: {
                        System.out.printf("Digite a operacao de soma:  [ Ex: 2+3+4+5 ] \n");
                        String numericListLine = scanner.nextLine();
                        String[] numericList = numericListLine.split("([+])");
                        somar(numericList);
                        break;
                    }
                    case SUBTRAIR: {
                        System.out.printf("Digite a operacao de subtracao: [ Ex: 14-4-5 ] \n");
                        String numericListLine = scanner.nextLine();
                        String[] numericList = numericListLine.split("([-])");
                        subtrair(numericList);
                        break;
                    }
                    case MULTIPLICAR: {
                        System.out.printf("Digite a operacao de multiplicação:  [ Ex: 2*3*4  ] \n");
                        String numericListLine = scanner.nextLine();
                        String[] numericList = numericListLine.split("([*])");
                        multiplicar(numericList);
                        break;
                    }
                    case DIVIDIR: {
                        System.out.printf("Digite a operacao de Divisão:  [ Ex: 5/2 ]  \n");
                        String numericListLine = scanner.nextLine();
                        String[] numericList = numericListLine.split("([/])");
                        dividir(numericList);
                        break;
                    }
                    default: {
                        System.out.printf("Nao consegui entender a operação matemática, pode repetir? \n");
                        break;
                    }
                }
            } catch (Exception err){
                System.out.printf("Não foi possivel entender a operacao matematica \n",err);
            }

            System.out.printf("Digite acao: ");
            actionUser = scanner.nextLine();
        }
        System.out.printf("Marciano modulo Math: Estou indo embora... ");

    }

    static int somar(String[] listNumber) {
        int result = 0;
        try{
            for ( String num: listNumber ){
                result = result + Integer.parseInt(num);
            }
        } catch (Exception e) {
            System.out.printf("Marciano modulo Math: Não foi possivel realizar a operação de soma... %s \n", e);

        }
        System.out.printf("Essa eu sei, o resultado é: %s \n", result);

        return result;
    }

    static int subtrair(String[] listNumber) {
        int result = Integer.parseInt(listNumber[0]);
        try{
            for (int i = 1; i <= listNumber.length; i++){
                result = result - Integer.parseInt(listNumber[i]);
            }
//            for ( String num: listNumber ){
//                result = result - Integer.parseInt(num);
//            }
        } catch (Exception e) {
            System.out.printf("Marciano modulo Math: Não foi possivel realizar a operação de subtracao... %s \n", e);

        }
        System.out.printf("Essa eu sei, o resultado é: %s \n", result);

        return result;
    }

    static int multiplicar(String[] listNumber) {
        int result = 1;
        try{
            for ( String num: listNumber ){
                result = result * Integer.parseInt(num);
            }
        } catch (Exception e) {
            System.out.printf("Marciano modulo Math: Não foi possivel realizar a operação de multiplicação... %s \n", e);
        }
        System.out.printf("Essa eu sei, o resultado é: %s \n", result);

        return result;
    }

    static float dividir(String[] listNumber) {
        float result = Float.parseFloat(listNumber[0]);

        try{
            for( String num: listNumber ) {
                if(Integer.parseInt(num) == 0) {
                    System.out.printf("Não é possivel fazer divisão por zero... %s \n");
                    return -1;
                }
            }
            for ( int i = 1; i < listNumber.length; i++){
                result = result / Integer.parseInt(listNumber[i]);
            }
        } catch (Exception e) {
            System.out.printf("Marciano modulo Math: Não foi possivel realizar a operação de divisão... %s \n", e);
        }
        System.out.printf("Essa eu sei, o resultado é: %s \n", result);

        return result;
    }
}

package com.example.demo;

import static com.example.demo.HelloApplication.scanner;

public class BotFun {

    private String botName = "Marciano Mode Fun:";

    private String action;

    public BotFun(String action) {
        this.action = action;
    }

    public void start(){
        System.out.printf("Olá meu nome é Marciano Fun e eu sei contar piadas, vamos começar? \n");
        System.out.printf("Escreva uma das palavras-chave: cafe, formiga, vampiro, planta ou fruta \n");
        String actionUser = scanner.nextLine();

        while (!actionUser.equals("FIM")) {
            switch (actionUser){
                case "cafe": {
                    coffee();
                    break;
                }
                case "formiga" : {
                    formiga();
                    break;
                }
                case "vampiro" : {
                    vampiro();
                    break;
                }
                case "planta" : {
                    planta();
                    break;
                }
                case "fruta" : {
                    fruta();
                    break;
                }
                default: {
                    System.out.printf(" Nao consegui encontrar a piada, você digitou a palavra chave correta? \n");
                    break;
                }
            }
            System.out.printf("Digite a palavra chave: ");
            actionUser = scanner.nextLine();

        }

    }

    static void coffee(){
        System.out.printf(" Eu tomo café. A Cláudia, leite. Eu tomo gelado. O Clark, Kent.\n");
    }

    static void formiga(){
        System.out.printf(" Por que a formiga tem quatro patas? Porque se ela tivesse cinco se chamaria fivemiga. \n");
    }

    static void vampiro(){
        System.out.printf(" Sabe qual é o cereal favorito do vampiro? Aveia. \n");
    }

    static void planta(){
        System.out.printf(" Por que as plantinhas não podem passar mal de madrugada?  R: Porque só tem médico de plantão. \n");
    }

    static void fruta(){
        System.out.printf(" Qual a fruta que anda de trem?  R: O kiwiiiii. \n");
    }

}

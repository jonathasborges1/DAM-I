package com.example.demo;

import com.google.common.base.CharMatcher;

import static com.example.demo.HelloApplication.scanner;

public class Bot {
    private String botName = "Marciano";
    private String keyword;

    public Bot(){ }
    public Bot(String _keyword) {
        this.keyword = _keyword;
    }

    public void start() {
        System.out.printf("Olá meu nome é Marciano, Vamos Conversar?\n");
          String phrase = scanner.nextLine();

          while (!phrase.equals("FIM")) {
              Bot bot = new Bot(phrase);

              if(!bot.botScreamWithQuestion()){
                  if ( !bot.botQuestion() && !bot.botScream() && !bot.botNotDisturb() && !bot.botIAM() ) {
                      bot.botAnyThingElse();
                  }
              }
              System.out.printf("Marciano: Continue escrevendo estou te ouvindo... \n");
              phrase = scanner.nextLine();

              if(phrase.equals("math")) {
                 BotMath botMath = new BotMath(phrase);
                 botMath.start();
              }

              if(phrase.equals("fun")) {
                 BotFun botFun = new BotFun(phrase);
                 botFun.start();
              }
          }


          System.out.printf("Marciano: Estou indo embora...");
          scanner.close();

          return;
      }


    public Boolean botQuestion() { // (1) - se alguém perguntar - o bot responde - "Certamente"
        String answerBot = "";

        if (checkLetterQuestion()) {
            answerBot = "Certamente";
            System.out.printf("%s: %s \n\r", botName, answerBot);
            return true;
        }
        return false;

    }

    boolean checkLetterQuestion() {
        String[] words = this.keyword.split("\\s+");

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (c == '?') {
                    return true;
                }
            }
        }

        return false;
    }

    public Boolean botScream() { // (2) - se alguém GRITAR- o bot responde - "Opa! Calma aí!"
        String answerBot = "";

        if (checkIsUpperCase()) { // Se retornar true significa que ele encontrou alguma palavra em CAPS LOCK
            answerBot = "Opa! Calma aí! \n\r";
            System.out.printf("%s: %s", botName, answerBot);
            return true;
        }
        return false;
    }

    boolean checkIsUpperCase() {
        if (this.keyword.length() < 1) {
            return false;
        }

        String regex = "[' ']";
        String[] words = this.keyword.split(regex);

        for (String word : words) {
            int sizeWord = word.length();
            int flagControll = 0;
            Boolean flagUpperCase = false;

            for (char letter : word.toCharArray()) {
                if (Character.isUpperCase(letter)) {
                    flagControll = flagControll + 1;
                }
            }
            if (sizeWord == flagControll) {
                flagUpperCase = true;
                return flagUpperCase;
            }
        }

        return false;  // Se nao encontrar CAPS LOCK então retorna FALSE
    }

    public boolean botScreamWithQuestion() { // (3) - se alguém GRITAR com ele em uma pergunta - "Relaxa, eu sei o que estou fazendo!"
        String answerBot = "";

        if (checkLetterQuestion() && checkIsUpperCase()) {
            answerBot = "Relaxa, eu sei o que estou fazendo!";
            System.out.printf("%s: %s \n\r", botName, answerBot);
        }

        if (answerBot.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean botIAM() {  // (4) - Se usar a palavra "eu" ele responde - "A responsabilidade é sua"
        String answerBot = "";
        String regex = "[' ']";
        String[] words = this.keyword.split(regex);

        for (String word : words) {
            if (word.equals("eu") || word.equals("Eu") || word.equals("eU") || word.equals("EU")) {
                answerBot = "A responsabilidade é sua";
                System.out.printf("%s: %s \n\r", botName, answerBot);
                return true;
            }
        }
        return false;
    }

    public boolean botNotDisturb() { // (5) - Se alguem se dirigir ao bot sem dizer qualquer palavra - o bot responde - "Não me incomode"
        String answerBot = "";

        if (this.keyword.length() < 1) {
            answerBot = "Não me incomode";
            System.out.printf("%s: %s \n\r", botName, answerBot);
            return true;
        }
        return false;
    }

    public void botAnyThingElse(){ // (6) - Caso alguem fale qualquer outras frase - o bot responde - "Tudo bem, como quiser"
        String answerBot = "";
        answerBot = "Tudo bem, como quiser";
        System.out.printf("%s: %s \n\r", botName, answerBot);
        return;
    }
}

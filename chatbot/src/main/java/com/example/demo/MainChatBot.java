package com.example.demo;

import java.util.Scanner;
public class MainChatBot{
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Bot bot = new Bot();
        bot.start();

        System.exit(1);

    }

}

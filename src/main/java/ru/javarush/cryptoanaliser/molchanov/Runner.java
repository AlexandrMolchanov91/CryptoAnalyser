package ru.javarush.cryptoanaliser.molchanov;

import ru.javarush.cryptoanaliser.molchanov.app.Application;
import ru.javarush.cryptoanaliser.molchanov.controller.MainController;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        System.out.println(Arrays.toString(args));
        Result result = new Result();

    }
}

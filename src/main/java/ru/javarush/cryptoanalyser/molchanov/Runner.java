package ru.javarush.cryptoanalyser.molchanov;

import ru.javarush.cryptoanalyser.molchanov.toplevel.Application;
import ru.javarush.cryptoanalyser.molchanov.controller.MainController;
import ru.javarush.cryptoanalyser.molchanov.entity.Result;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        System.out.println(Arrays.toString(args));
        Result result = application.run(args);
        System.out.println(result.toString());

    }
}

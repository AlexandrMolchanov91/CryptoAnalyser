package ru.javarush.cryptoanalyser.molchanov.controller;

import ru.javarush.cryptoanalyser.molchanov.commands.Action;
import ru.javarush.cryptoanalyser.molchanov.commands.BruteForce;
import ru.javarush.cryptoanalyser.molchanov.commands.Decoder;
import ru.javarush.cryptoanalyser.molchanov.commands.Encoder;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new BruteForce());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}

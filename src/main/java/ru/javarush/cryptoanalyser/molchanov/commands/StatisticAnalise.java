package ru.javarush.cryptoanalyser.molchanov.commands;

import ru.javarush.cryptoanalyser.molchanov.Exception.ApplicationException;
import ru.javarush.cryptoanalyser.molchanov.entity.Result;
import ru.javarush.cryptoanalyser.molchanov.entity.ResultCode;
import ru.javarush.cryptoanalyser.molchanov.util.PathFinder;
import ru.javarush.cryptoanalyser.molchanov.util.TextUtilMethods;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class StatisticAnalise implements Action{
    @Override
    public Result execute(String[] parameters) {
        String encodedFile = parameters[0];
        String textForAnalise = parameters[1];
        Path pathEncodedText = Path.of(PathFinder.getRoot() + encodedFile);
        Path pathOfTextForAnalise = Path.of(PathFinder.getRoot() + textForAnalise);
        Path pathOut = Path.of(PathFinder.getRoot() + "decoded.txt");
        List<String> linesOfEncodedText;
        List<String> linesOfAnalisedText;

        try {
            linesOfEncodedText = Files.readAllLines(pathEncodedText, StandardCharsets.UTF_8);
            linesOfAnalisedText = Files.readAllLines(pathOfTextForAnalise, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ApplicationException("FileNotFound");
        }
        char[] encodedTextInChar = TextUtilMethods.textInCharArray(linesOfEncodedText);
        char[] analyzedTextToChar = TextUtilMethods.textInCharArray(linesOfAnalisedText);

        Character[] encodedTextInCharacter = TextUtilMethods.charToCharacterArray(encodedTextInChar);
        Character[] analyzedTextInCharacter= TextUtilMethods.charToCharacterArray(analyzedTextToChar);

        TreeMap<Character, Double> encodedTextStatistic = TextUtilMethods.textAnalise(encodedTextInCharacter);
        TreeMap<Character, Double> analyzedTextStatistic = TextUtilMethods.textAnalise(analyzedTextInCharacter);
        System.out.println(encodedTextStatistic.toString());
        System.out.println(analyzedTextStatistic.toString());

        try {
            Files.writeString(pathOut, String.copyValueOf(encodedTextInChar));
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, "Writing to file failed" + pathOut);
        }
        return new Result(ResultCode.OK, "Text was decoded" + pathOut);
    }
}

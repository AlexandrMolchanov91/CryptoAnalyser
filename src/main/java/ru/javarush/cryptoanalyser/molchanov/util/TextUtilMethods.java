package ru.javarush.cryptoanalyser.molchanov.util;

import java.util.List;

public class TextUtilMethods {
    public static char[] textInCharArray (List<String> allLines){
        StringBuilder s = new StringBuilder();
        for (String str : allLines) {
            s.append(str+ "\n");
        }
        char[] allSymbolsInText = new char[s.length()];
        s.getChars(0, s.length(), allSymbolsInText, 0);

        return allSymbolsInText;
    }
}

package ru.javarush.cryptoanalyser.molchanov.util;

import ru.javarush.cryptoanalyser.molchanov.constants.Strings;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TextUtilMethods {
    public static char[] textInCharArray (List<String> allLines){
        StringBuilder s = new StringBuilder();
        for (String str : allLines) {
            s.append(str).append("\n");
        }
        char[] allSymbolsInText = new char[s.length()];
        s.getChars(0, s.length(), allSymbolsInText, 0);

        return allSymbolsInText;
    }

    private static TreeMap<Character, Double> AlphabetToTreeMap (Character[] alphabet){
        TreeMap<Character, Double> alphabetCharWithCount = new TreeMap<>();
        for (Character character : alphabet) {
            alphabetCharWithCount.put(character, 0.0);
        }
        return alphabetCharWithCount;
    }

    public static TreeMap<Character, Double> textAnalise(Character[] text) {
        TreeMap<Character, Double> statisticOfLettersInText = AlphabetToTreeMap(Strings.alphabet);
        for (Map.Entry<Character, Double> entry: statisticOfLettersInText.entrySet()) {
            Character target = entry.getKey();
            int countOfTarget = 0;
            for (Character c: text) {
                if(c.equals(target)) countOfTarget++;
            }
            statisticOfLettersInText.put(target, round(countOfTarget*1.0/text.length*100, 3));
        }
        return statisticOfLettersInText;
    }
    public static Character[] charToCharacterArray(char[] arr){
        Character[] ch = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ch[i] = arr[i];
        }
        return ch;
    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

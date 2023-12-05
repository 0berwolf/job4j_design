package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("123");
        String text1 = "1231 and 1232 and 1233";
        Matcher matcher1 = pattern.matcher(text1);
        String rsl = matcher1.replaceAll("Job4j");
            System.out.println(rsl);
    }
}

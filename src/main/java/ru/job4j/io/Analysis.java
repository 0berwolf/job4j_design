package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean workUnavailable = false;
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String s;
            while ((s = in.readLine()) != null) {
                String[] splitLine = s.split(" ");
                if (("400".equals(splitLine[0]) || "500".equals(splitLine[0])) != workUnavailable) {
                    workUnavailable = !workUnavailable;
                    out.append(splitLine[1]).append(";").append(workUnavailable ? "" : System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}

package ru.job4j.io;
import java.io.File;
import java.io.IOException;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("Disc size : %s gb", file.getTotalSpace() / 1073741824));
        for (File subfile : file.listFiles()) {
            System.out.print(String.format(subfile.getName()));
            System.out.println(String.format(", size : %s", subfile.length() / 1024 + "kb"));
        }
    }
}

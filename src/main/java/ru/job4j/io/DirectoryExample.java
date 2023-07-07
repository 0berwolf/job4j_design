package ru.job4j.io;

import java.io.File;
import java.io.IOException;

public class DirectoryExample {
    public static void main(String[] args) throws IOException {
        File dir = new File("src/main/java/ru/job4j/io/files/directory");
        dir.mkdirs();
        File target = new File("src/main/java/ru/job4j/io/files");
        File file1 = new File("src/main/java/ru/job4j/io/files/file1.txt");
        file1.createNewFile();
        File file2 = new File("src/main/java/ru/job4j/io/files/file2.txt");
        file2.createNewFile();
        String[] list = target.list();
        for (String d: list) {
            System.out.println(d);
        }
        File[] listFiles = target.listFiles();
        for (File d: listFiles) {
            System.out.println(d);
        }
    }
}

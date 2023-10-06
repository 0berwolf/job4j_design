package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        verification(args);
        Path start = Path.of(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void verification(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Использовать 2 параметра: ROOT_FOLDER FILE_EXTENSION");
        }
        if (!Files.isDirectory(Path.of(args[0]))) {
            throw new IllegalArgumentException("Данный директорий не существует. Use ROOT_FOLDER.");
        }
        if (args[1].lastIndexOf(".") != 0 || args[1].length() < 2) {
            throw new IllegalArgumentException("Использовать следующий формат для параметра: \".FILE_EXTENSION\"");
        }
    }
}
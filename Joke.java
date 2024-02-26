package Joke;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;


public class Joke {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        Path startingDir = Paths.get(path);
        JokeFileVisitor fileVisitor = new JokeFileVisitor(startingDir);
        Files.walkFileTree(startingDir, fileVisitor);
    }
}
// D:\Programm test

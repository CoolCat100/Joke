import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

import static java.nio.file.FileVisitResult.*;

public class Joke extends SimpleFileVisitor<Path> {
    private static Path START_DIRECTORY;

    public Joke(Path START_DIRECTORY) {
        this.START_DIRECTORY = START_DIRECTORY;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        Path startingDir = Paths.get(path);
        Joke joke = new Joke(startingDir);
        Files.walkFileTree(START_DIRECTORY, joke);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attrs) throws IOException {
        Files.createFile(Path.of(directory + "\\\\joke.java"));
        OutputStream writer = Files.newOutputStream(Path.of(directory + "\\\\joke.java"));
        String programText = "public class HelloWorld { \n" +
                "public static void main(String[] args) { \n" +
                "System.out.println(\"Hello World\"); \n } \n }";
        writer.write(programText.getBytes());
        writer.close();
        return CONTINUE;
    }
}
// D:\Programm test

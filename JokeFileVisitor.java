package Joke;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class JokeFileVisitor extends SimpleFileVisitor<Path> {
    private static Path START_DIRECTORY;
    public static final String PROGRAM_TEXT = "public class HelloWorld { \n" +
            "public static void main(String[] args) { \n" +
            "System.out.println(\"Hello World\"); \n } \n }";

    public JokeFileVisitor(Path START_DIRECTORY) {
        this.START_DIRECTORY = START_DIRECTORY;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attrs) throws IOException {
        Files.createFile(Path.of(directory + "\\\\joke.java"));
        writeCode(directory);
        return CONTINUE;
    }

    public void writeCode(Path directory) throws IOException {
        OutputStream writer = Files.newOutputStream(Path.of(directory + "\\\\joke.java"));
        writer.write(PROGRAM_TEXT.getBytes());
        writer.close();
    }
}

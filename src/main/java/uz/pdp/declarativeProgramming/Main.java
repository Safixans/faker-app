package uz.pdp.declarativeProgramming;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/safixonabdusattorov/Java online tasks/faker-app/out/artifacts/seeder.jar/students");
        String jsonData = Files.readString(path);
        Gson gson = new Gson();


        Stream<String> java = Stream.of("Java", "pyhton", "Scala");



    }
}

package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import model.Product;
import net.serenitybdd.rest.SerenityRest;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@UtilityClass
@Slf4j
public class EnvironmentController {

    @NotNull
    public List<Product> getJsonArrayFromFile(String file) throws IOException {
        String path = System.getProperty("user.dir");
        Reader reader = Files.newBufferedReader(Paths.get(path + "/src/main/java/resources/" + file + ".json"));
        return (new Gson().fromJson(reader, new TypeToken<List<Product>>() {
        }.getType()));
    }

    public List<Product> getJsonArrayFromLastResponse() {
        return SerenityRest.lastResponse().getBody().jsonPath().get();
    }

}

package Service.File;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileService {
    private final String directory = "src/main/resources/";

    public String getRulesFromTXT(String fileName) throws IOException {
        String textRules = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(directory + fileName)))  {
            String str;
            while ((str = reader.readLine()) != null)
                textRules += str;
        }
        return textRules;
    }
}

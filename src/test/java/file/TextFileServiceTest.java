package file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.file.TextFileService;

import java.io.IOException;

public class TextFileServiceTest {

    @Test
    public void readTextFromFileTest() throws IOException {
        String assertTrue = "This test text...\nLine 2.\n";
        TextFileService textFileService = new TextFileService();
        String result = textFileService.readTextFromFile("src/test/java/file/", "TestReadFile.txt");
        Assertions.assertEquals(assertTrue, result);
    }

    @Test
    public void writeTextToFileTest() throws IOException {
        String expectedText = "One, two, three\n TEst\n";
        TextFileService textFileService = new TextFileService();
        textFileService.writeTextToFile("src/test/java/file/", "TestWriteFile.txt", expectedText);
        String readText = textFileService.readTextFromFile("src/test/java/file/", "TestWriteFile.txt");
        Assertions.assertEquals(expectedText, readText);
    }
}

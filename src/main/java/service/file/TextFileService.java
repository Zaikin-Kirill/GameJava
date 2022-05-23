package service.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс работы с текстовыми файлами.
 */
public class TextFileService implements FileService {

    @Override
    public String readTextFromFile(String path, String fileName) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path + fileName))) {
            String str;
            while ((str = br.readLine()) != null) {
                text.append(str);
                text.append("\n");
            }
            return text.toString();
        }
    }

    @Override
    public void writeTextToFile(String path, String fileName, String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName))) {
            writer.write(text);
        }
    }
}

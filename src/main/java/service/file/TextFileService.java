package service.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

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

    @Override
    public void deleteAllFilesFolder(String path) {
        for (File myFile : Objects.requireNonNull(new File(path).listFiles())){
            if (myFile.isFile()) {
                boolean result = myFile.delete();
            }
        }
    }

    @Override
    public boolean checkExistFile(String path){
        Path pathFile = Paths.get(path);
        return Files.exists(pathFile) && !Files.isDirectory(pathFile);
    }
}

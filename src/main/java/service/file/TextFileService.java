package service.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        for (File myFile : Objects.requireNonNull(new File(path).listFiles())) {
            if (myFile.isFile()) {
                myFile.delete();
            }
        }
    }

    @Override
    public boolean checkSaveFile() {
        String[] paths = new String[]{FileService.saveDirectory + FileService.saveHeroGamerFile,
                FileService.saveDirectory + FileService.saveHeroComputerFile,
                FileService.saveDirectory + FileService.saveItemGamerFile,
                FileService.saveDirectory + FileService.saveItemComputerFile};
        for (String path : paths) {
            Path pathFile = Paths.get(path);
            if (!Files.exists(pathFile)) {
                return false;
            }
        }
        return true;
    }
}

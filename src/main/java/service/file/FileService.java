package service.file;

import java.io.IOException;

/**
 * Интерфейс работы с файлами.
 */
public interface FileService {

    String readDirectory = "src/main/resources/";
    String saveDirectory = "src/main/resources/savegame/";
    String saveHeroGamerFile = "heroGamer.json";
    String saveHeroComputerFile = "heroComputer.json";
    String saveItemGamerFile = "itemGamer.json";
    String saveItemComputerFile = "itemComputer.json";

    /**
     * Чтение из файла.
     *
     * @param path - путь до файла
     * @param fileName - имя файла
     * @return - прочитанная строка
     */
    String readTextFromFile(String path, String fileName) throws IOException;

    /**
     * Запись в файл.
     *
     * @param path - путь до файла
     * @param fileName - имя файла
     * @param text - строка для записи
     */
    void writeTextToFile(String path, String fileName, String text) throws IOException;

    void deleteAllFilesFolder(String path);

    boolean checkSaveFile();
}

package service.game;

import java.io.IOException;
import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;
import service.file.FileService;
import service.file.TextFileService;
import service.io.ConsoleMassageService;
import service.parser.JsonParserService;

/**
 * Класс загрузки игры.
 */
public class LoadGame {

    /**
     * Вызов загрузки игры.
     */
    public void loadSaveGame() {
        try {
            ChoiceUser.setHeroGamer(new JsonParserService().getHeroFromString(
                    new TextFileService().readTextFromFile(FileService.saveDirectory, FileService.saveHeroGamerFile)));
            ChoiceComputer.setHeroComputer(new JsonParserService().getHeroFromString(
                    new TextFileService().readTextFromFile(FileService.saveDirectory,
                            FileService.saveHeroComputerFile)));
            ChoiceUser.setItemsGamer(new JsonParserService().getAllSimpleItemFromString(
                    new TextFileService().readTextFromFile(FileService.saveDirectory, FileService.saveItemGamerFile)));
            ChoiceComputer.setItemsComputer(new JsonParserService().getAllSimpleItemFromString(
                    new TextFileService().readTextFromFile(
                            FileService.saveDirectory, FileService.saveItemComputerFile)));
            printLoadSaveGame();
        } catch (IOException mes) {
            ConsoleMassageService.getInstance().print(mes.getMessage());
        }
    }

    private void printLoadSaveGame() {
        ConsoleMassageService.getInstance().print("Игра загружена. Сохраненные параметры игры:");
        new GameService().printAllInfo();
    }
}

package service.game;

import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;
import service.file.FileService;
import service.file.TextFileService;
import service.io.ConsoleMassageService;
import service.parser.JsonParserService;

import java.io.IOException;

public class LoadGame {

    public static void loadSaveGame() {
        try {
            ChoiceUser.setHeroGamer(new JsonParserService().getHeroFromString(
                    new TextFileService().readTextFromFile(FileService.saveDirectory, FileService.saveHeroGamerFile)));
            ChoiceComputer.setHeroComputer(new JsonParserService().getHeroFromString(
                    new TextFileService().readTextFromFile(FileService.saveDirectory, FileService.saveHeroComputerFile)));
            ChoiceUser.setItemsGamer(new JsonParserService().getAllSimpleItemFromString(
                    new TextFileService().readTextFromFile(FileService.saveDirectory, FileService.saveItemGamerFile)));
            ChoiceComputer.setItemsComputer(new JsonParserService().getAllSimpleItemFromString(
                    new TextFileService().readTextFromFile(
                            FileService.saveDirectory, FileService.saveItemComputerFile)));
        } catch (IOException mes) {
            ConsoleMassageService.getInstance().print(mes.getMessage());
        }
    }
}

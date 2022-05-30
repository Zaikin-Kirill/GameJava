package menu;

import model.Hero;
import service.file.FileService;
import service.file.TextFileService;
import service.game.LoadGame;
import service.game.StepGame;
import service.parser.JsonParserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс главного меню программы.
 */
public class MainMenu extends MenuEntry {

    private final List<MenuEntry> menu = new ArrayList<>();
    private int serialNumber = 1;

    public MainMenu() {
    }

    public MainMenu(String title) {
        super(title);
    }

    @Override
    public void run() {

        addPoint(new RuleMenu( serialNumber + ". Правила игры"));

        if (new TextFileService().checkSaveFile()) {
            LoadGame.loadSaveGame();
            addPoint(new StepSelectArtefactMenu( serialNumber + ". Продолжить игру"));
        }

        addPoint(new SelectHeroMenu(serialNumber + ". Начать новую игру"));
        addPoint(new ExitMenu(serialNumber + ". Выход"));
        super.printTitle("Привет, юзер! Давай сыграем в игру 'Битва Героев'. \nВыбери действие:");
        super.printMenu(menu);
        int selectedNumberUser = super.selectedNumberUser();
        super.selectItemMenu(menu, selectedNumberUser);
    }



    private void addPoint(MenuEntry entry) {
        menu.add(entry);
        serialNumber++;
    }


}

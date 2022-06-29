package menu;

import java.util.ArrayList;
import java.util.List;
import service.file.TextFileService;

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

        addPoint(new HttpRequestMenu(serialNumber + ". Отправить запрос"));
        addPoint(new RuleMenu(serialNumber + ". Правила игры"));

        if (new TextFileService().checkSaveFile()) {
            addPoint(new StepSelectArtefactMenu(serialNumber + ". Продолжить игру", true));
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

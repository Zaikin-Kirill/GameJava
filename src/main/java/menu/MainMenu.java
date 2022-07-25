package menu;

import service.file.TextFileService;

/**
 * Класс главного меню программы.
 */
public class MainMenu extends MenuEntry {


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
        int selectedNumberUser = super.selectedNumberUser(serialNumber);
        super.selectItemMenu(menu, selectedNumberUser);
    }

}

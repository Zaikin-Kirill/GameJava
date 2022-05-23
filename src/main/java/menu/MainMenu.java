package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс главного меню программы.
 */
public class MainMenu extends MenuEntry {

    private final List<MenuEntry> menu = new ArrayList<>();

    public MainMenu() {
    }

    public MainMenu(String title) {
        super(title);
    }

    @Override
    public void run() {
        addPoint(new RuleMenu("1. Правила игры"));
        addPoint(new SelectHeroMenu("2. Играть"));
        addPoint(new ExitMenu("3. Выход"));
        super.printTitle("Привет, юзер! Давай сыграем в игру 'Битва Героев'. \nВыбери действие:");
        super.printMenu(menu);
        int selectedNumberUser = super.selectedNumberUser();
        super.selectItemMenu(menu, selectedNumberUser);
    }


    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }


}

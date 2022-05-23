package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Меню началы игры.
 */
public class StartGameMenu extends MenuEntry {

    private final List<MenuEntry> menu = new ArrayList<>();


    public StartGameMenu(String title) {
        super(title);
    }

    @Override
    public void run() {
        addPoint(new MainMenu("1. Вернуться в главное меню"));
        addPoint(new ExitMenu("2. Выход"));
        super.printTitle("Упс, игры еще нет :(");
        super.printMenu(menu);
        int selectedNumberUser = super.selectedNumberUser();
        super.selectItemMenu(menu, selectedNumberUser);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }
}

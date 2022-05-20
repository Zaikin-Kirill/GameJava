package menu;

import java.util.ArrayList;
import java.util.List;

public class ReadyStartGameMenu extends MenuEntry{

    public ReadyStartGameMenu(String title) {
        super(title);
    }

    public ReadyStartGameMenu(){}

    private final List<MenuEntry> menu = new ArrayList<>();

    @Override
    public void run() {
        addPoint(new StartGameMenu("1. Да"));
        addPoint(new SelectHeroMenu("2. Вернуться в выбор персонажа"));
        addPoint(new ExitMenu("3. Выход"));
        super.printTitle("Начать игру?");
        super.printMenu(menu);
        int _selectedNumberUser = super.selectedNumberUser();
        super.selectItemMenu(menu, _selectedNumberUser);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }
}

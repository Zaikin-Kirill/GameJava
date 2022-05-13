package menu;

import java.util.ArrayList;
import java.util.List;

public class StartGameMenu extends MenuEntry {

    private final List<MenuEntry> menu = new ArrayList<>();

    public StartGameMenu(String title) {
        super(title);
    }

    @Override
    public void run(){
        addPoint(new MainMenu("1. Вернуться в меню"));
        addPoint(new ExitMenu("2. Выход"));
        super.printTitle("Тут игра");
        super.printMenu(menu);
        super.selectItemMenu(menu);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }
}

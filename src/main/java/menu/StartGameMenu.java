package menu;

import java.util.ArrayList;
import java.util.List;

public class StartGameMenu extends MenuEntry {

    private final List<MenuEntry> menu = new ArrayList<>();

    public StartGameMenu() {}

    public StartGameMenu(String title) {
        super(title);
    }

    @Override
    public void run(){
        addPoint(new MainMenu("1. Вернуться в главное меню"));
        addPoint(new ExitMenu("2. Выход"));
        super.printTitle("Упс, игры еще нет :(");
        super.printMenu(menu);
        int _selectedNumberUser = super.selectedNumberUser();
        super.selectItemMenu(menu, _selectedNumberUser);
        //super.selectItemMenu(menu);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }
}

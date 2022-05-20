package menu;

import java.util.*;

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
        //addPoint(new StartGameMenu("2. Играть"));
        addPoint(new SelectHeroMenu("2. Играть"));
        addPoint(new ExitMenu("3. Выход"));
        //printTitle("Привет, юзер! Давай сыграем в игру 'Битва Героев'. \nВыбери действие:");
        super.printTitle("Привет, юзер! Давай сыграем в игру 'Битва Героев'. \nВыбери действие:");
        //PrintMenu(menu);
        super.printMenu(menu);
        int _selectedNumberUser = super.selectedNumberUser();
        super.selectItemMenu(menu, _selectedNumberUser);
//        super.selectItemMenu(menu);
    }


    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }


}

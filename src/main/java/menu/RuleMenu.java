package menu;

import service.file.TextFileService;
import service.IO.ConsoleMassageService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RuleMenu extends MenuEntry {


    public RuleMenu(String title) {
        super(title);
    }

    private final List<MenuEntry> menu = new ArrayList<>();


    @Override
    public void run(){
        addPoint(new MainMenu("1. Вернуться в меню"));
        addPoint(new ExitMenu("2. Выход"));
        super.printTitle("Правила игры:");
        printTextRules();
        super.printMenu(menu);
        super.selectItemMenu(menu);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }

    private void printTextRules(){
        try {
            ConsoleMassageService.getInstance().print(new TextFileService().readTextFromFile("rules.txt"));
        } catch (IOException e) {
            ConsoleMassageService.getInstance().print(e.getMessage());
        }
    }
}

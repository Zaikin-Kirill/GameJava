package Menu;

import Service.File.TextFileService;
import Service.IO.ConsoleMassageService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RuleMenu extends MenuEntry {


    public RuleMenu(String title) {
        super(title);
    }

    private List<MenuEntry> menu = new ArrayList<>();


    @Override
    public void run(){
        addPoint(new MainMenu("1. Вернуться в меню"));
        addPoint(new ExitMenu("2. Выход"));
        super.printTitle("Правила игры:");
        printTextRules();
        super.PrintMenu(menu);
        super.selectItemMenu(menu);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }

    private void printTextRules(){
        try {
            new ConsoleMassageService().print(new TextFileService().getRulesFromTXT("rules.txt"));
        } catch (IOException e) {
            new ConsoleMassageService().print(e.getMessage());
        }
    }
}

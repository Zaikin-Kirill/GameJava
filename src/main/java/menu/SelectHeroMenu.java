package menu;

import model.Hero;
import service.file.TextFileService;
import service.parser.JsonParserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectHeroMenu extends MenuEntry{

    private final List<MenuEntry> menu = new ArrayList<>();
    private int serialNumber = 1;

    public SelectHeroMenu(String title) {
        super(title);
    }

    @Override
    public void run() {
        super.printTitle("Выберите персонажа:");
        List<Hero> listHero = new ArrayList<>(){};
        try {
            listHero = new JsonParserService().getAllHeroFromString(new TextFileService().readTextFromFile("hero.json"));
            for (Hero hero: listHero) {
                super.printTitle(serialNumber + ". " + hero.getName());
                serialNumber++;
            }
        }
        catch (IOException mes) {
            super.printTitle(mes.getMessage());
        }

        addPoint(new MainMenu(serialNumber + ". " + "Вернуться в меню"));
        addPoint(new ExitMenu(serialNumber + ". " + "Выход"));

        super.printMenu(menu);
        //super.selectItemMenu(menu);
        super.selectItemMenuWithSelectHero(menu, listHero);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
        serialNumber++;
    }
}

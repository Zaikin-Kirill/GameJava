package menu;

import model.Hero;
import model.SimpleItem;
import service.file.TextFileService;
import service.parser.JsonParserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectArtefactMenu extends MenuEntry {

    private final List<MenuEntry> menu = new ArrayList<>();
    private int serialNumber = 1;

    @Override
    public void run() {
        super.printTitle("Выберите оружие или защиту:");
        List<SimpleItem> listSimpleItem = new ArrayList<>(){};
        try {
            listSimpleItem = new JsonParserService().getAllSimpleItemFromString(new TextFileService().readTextFromFile("item.json"));
            for (SimpleItem simpleItem: listSimpleItem) {
                super.printTitle(serialNumber + ". " + simpleItem.getName());
                serialNumber++;
            }
        }
        catch (IOException mes) {
            super.printTitle(mes.getMessage());
        }

        addPoint(new SelectHeroMenu(serialNumber + ". " + "Вернуться в меню выбора артефакта"));
        addPoint(new ExitMenu(serialNumber + ". " + "Выход"));

        super.printMenu(menu);
        super.selectItemMenuWithSelectHero(menu, listSimpleItem);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
        serialNumber++;
    }
}

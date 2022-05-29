package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.SimpleItem;
import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;
import service.file.FileService;
import service.file.TextFileService;
import service.io.ConsoleMassageService;
import service.parser.JsonParserService;


/**
 * Меню выбора артефактов.
 */
public class SelectArtefactMenu extends MenuEntry {

    private final List<MenuEntry> menu = new ArrayList<>();
    private int serialNumber = 1;

    @Override
    public void run() {
        super.printTitle("Выберите оружие или защиту:");
        List<SimpleItem> listSimpleItem = new ArrayList<>() {
        };
        try {
            listSimpleItem = new JsonParserService().getAllSimpleItemFromString(
                    new TextFileService().readTextFromFile(FileService.readDirectory, "item.json"));
            for (SimpleItem simpleItem : listSimpleItem) {
                super.printTitle(serialNumber + ". " + simpleItem.getType());
                serialNumber++;
            }
        } catch (IOException mes) {
            super.printTitle(mes.getMessage());
        }

        addPoint(new SelectHeroMenu(serialNumber + ". " + "Вернуться в меню выбора персонажа"));
        addPoint(new ExitMenu(serialNumber + ". " + "Выход"));

        super.printMenu(menu);
        selectOrJumpMenu(listSimpleItem);
    }

    private void selectOrJumpMenu(List<SimpleItem> listSimpleItem) {
        try {
            int selectedNumberUser = super.selectedNumberUser();
            if (selectedNumberUser < listSimpleItem.size()) {
                selectSimpleItem(listSimpleItem, selectedNumberUser);
            } else {
                super.selectItemMenu(menu, selectedNumberUser - listSimpleItem.size());
            }
        } catch (IndexOutOfBoundsException e) {
            ConsoleMassageService.getInstance().print("Введите число из диапазона меню");
            selectOrJumpMenu(listSimpleItem);
        }
    }

    private void selectSimpleItem(List<SimpleItem> listSimpleItem, int indexSelected) {
        try {
            new ChoiceUser().selectedItem(listSimpleItem.get(indexSelected));
            if (ChoiceUser.getItems().size() != ChoiceUser.getCountItems()) {
                new SelectArtefactMenu().run();
            } else {
                do {
                    doChoiceItemsComputer(listSimpleItem);
                } while (ChoiceComputer.getItems().size() != ChoiceComputer.getCountItems());
                new ReadyStartGameMenu().run();
            }
        } catch (IOException mes) {
            ConsoleMassageService.getInstance().print(mes.getMessage());
            selectOrJumpMenu(listSimpleItem);
        }

    }

    private void doChoiceItemsComputer(List<SimpleItem> listSimpleItem) {
        listSimpleItem.removeAll(ChoiceUser.getItems());
        ChoiceComputer choiceComputer = new ChoiceComputer();
        try {
            choiceComputer.selectedItem(
                    choiceComputer.getRandomItemFromListWithoutUserItems(listSimpleItem));
        } catch (IOException mes) {
            ConsoleMassageService.getInstance().print(mes.getMessage());
        }
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
        serialNumber++;
    }
}

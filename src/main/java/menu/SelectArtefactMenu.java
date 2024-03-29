package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Item;
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


    /**
     * Сервис вывода на экран.
     */
    private final ConsoleMassageService consoleMassageService = ConsoleMassageService.getInstance();

    @Override
    public void run() {
        super.printTitle("Выберите оружие или защиту:");
        List<Item> listSimpleItem = new ArrayList<>() {
        };
        try {
            listSimpleItem = new JsonParserService().getAllSimpleItemFromString(
                    new TextFileService().readTextFromFile(FileService.readDirectory, "item.json"));
            for (Item simpleItem : listSimpleItem) {
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

    private void selectOrJumpMenu(List<Item> listSimpleItem) {
        try {
            int selectedNumberUser = super.selectedNumberUser(serialNumber);
            if (selectedNumberUser < listSimpleItem.size()) {
                selectSimpleItem(listSimpleItem, selectedNumberUser);
            } else {
                super.selectItemMenu(menu, selectedNumberUser - listSimpleItem.size());
            }
        } catch (IndexOutOfBoundsException e) {
            consoleMassageService.print("Введите число из диапазона меню");
            selectOrJumpMenu(listSimpleItem);
        }
    }

    private void selectSimpleItem(List<Item> listSimpleItem, int indexSelected) {
        try {
            ChoiceUser choiceUser = new ChoiceUser();
            choiceUser.selectedItem(listSimpleItem.get(indexSelected));
            if (ChoiceUser.getItems().size() != choiceUser.getCountItems()) {
                new SelectArtefactMenu().run();
            } else {
                do {
                    doChoiceItemsComputer(listSimpleItem);
                } while (ChoiceComputer.getItems().size() != new ChoiceComputer().getCountItems());
                new ReadyStartGameMenu().run();
            }
        } catch (IOException mes) {
            consoleMassageService.print(mes.getMessage());
            selectOrJumpMenu(listSimpleItem);
        }

    }

    private void doChoiceItemsComputer(List<Item> listSimpleItem) {
        listSimpleItem.removeAll(ChoiceUser.getItems());
        ChoiceComputer choiceComputer = new ChoiceComputer();
        try {
            choiceComputer.selectedItem(
                    choiceComputer.getRandomItemFromListWithoutUserItems(listSimpleItem));
        } catch (IOException mes) {
            consoleMassageService.print(mes.getMessage());
        }
    }

}

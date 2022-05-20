package menu;

import model.Hero;
import model.Item;
import model.SimpleItem;
import service.ChoiceItem.ChoiceComputer;
import service.ChoiceItem.ChoiceUser;
import service.file.TextFileService;
import service.io.ConsoleMassageService;
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
        List<SimpleItem> listSimpleItem = new ArrayList<>() {
        };
        try {
            listSimpleItem = new JsonParserService().getAllSimpleItemFromString(new TextFileService().readTextFromFile("item.json"));
            for (SimpleItem simpleItem : listSimpleItem) {
                super.printTitle(serialNumber + ". " + simpleItem.getName());
                serialNumber++;
            }
        } catch (IOException mes) {
            super.printTitle(mes.getMessage());
        }

        addPoint(new SelectHeroMenu(serialNumber + ". " + "Вернуться в меню выбора персонажа"));
        addPoint(new ExitMenu(serialNumber + ". " + "Выход"));

        super.printMenu(menu);
        selectOrJumpMenu(listSimpleItem);
        //super.selectItemMenuWithSelectHero(menu, listSimpleItem);
    }

    private void selectOrJumpMenu(List<SimpleItem> listSimpleItem) {
        try {
            int _selectedNumberUser = super.selectedNumberUser();
            if (_selectedNumberUser < listSimpleItem.size()) {
                selectSimpleItem(listSimpleItem, _selectedNumberUser);
            } else {
                super.selectItemMenu(menu, _selectedNumberUser - listSimpleItem.size());
            }
        } catch (IndexOutOfBoundsException e) {
            ConsoleMassageService.getInstance().print("Введите число из диапазона меню");
            selectOrJumpMenu(listSimpleItem);
        }
    }

    private void selectSimpleItem(List<SimpleItem> listSimpleItem, int indexSelected) {
        try {
            new ChoiceUser().SelectedItem(listSimpleItem.get(indexSelected));
            if (ChoiceUser.getItemsGamer().size() != ChoiceUser.getCountItems()) {
                new SelectArtefactMenu().run();
            } else {
                ConsoleMassageService.getInstance().print("Ваши выбранные артефакты: ");
                for (Item item : ChoiceUser.getItemsGamer()) {
                    ConsoleMassageService.getInstance().print(item.toString());
                }
                do {
                    doChoiceItemsComputer(listSimpleItem);
                } while (ChoiceComputer.getItemsComputer().size() != ChoiceComputer.getCountItems());
                new ReadyStartGameMenu().run();
            }
        } catch (IOException mes) {
            ConsoleMassageService.getInstance().print(mes.getMessage());
            selectOrJumpMenu(listSimpleItem);
        }

    }

    private void doChoiceItemsComputer(List<SimpleItem> listSimpleItem) {
        listSimpleItem.removeAll(ChoiceUser.getItemsGamer());
        ChoiceComputer choiceComputer = new ChoiceComputer();
        try {
            choiceComputer.SelectedItem(choiceComputer.getRandomItemFromListWithoutUserItems(listSimpleItem));
        } catch (IOException mes) {
            ConsoleMassageService.getInstance().print(mes.getMessage());
        }
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
        serialNumber++;
    }
}

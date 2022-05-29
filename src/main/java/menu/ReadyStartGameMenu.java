package menu;

import java.util.ArrayList;
import java.util.List;
import model.Item;
import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;
import service.io.ConsoleMassageService;


/**
 * Меню подтверждения начала игры.
 */
public class ReadyStartGameMenu extends MenuEntry {

    public ReadyStartGameMenu() {
    }

    private final List<MenuEntry> menu = new ArrayList<>();

    @Override
    public void run() {
        addPoint(new StepSelectArtefactMenu("1. Да"));
        addPoint(new SelectHeroMenu("2. Вернуться в выбор персонажа"));
        addPoint(new ExitMenu("3. Выход"));

        ConsoleMassageService.getInstance()
                .print("Ваш герой:", ConsoleMassageService.Color.GREEN);
        ConsoleMassageService.getInstance()
                .print(ChoiceUser.getHero().toString(), ConsoleMassageService.Color.GREEN);
        ConsoleMassageService.getInstance()
                .print("Ваши артефакты: ", ConsoleMassageService.Color.GREEN);
        for (Item item : ChoiceUser.getItems()) {
            ConsoleMassageService.getInstance()
                    .print(item.toString(), ConsoleMassageService.Color.GREEN);
        }

        ConsoleMassageService.getInstance()
                .print("Герой компьютера:", ConsoleMassageService.Color.PURPLE);
        ConsoleMassageService.getInstance()
                .print(ChoiceComputer.getHero().toString(), ConsoleMassageService.Color.PURPLE);
        ConsoleMassageService.getInstance()
                .print("Артефакты компьютера: ", ConsoleMassageService.Color.PURPLE);
        for (Item item : ChoiceComputer.getItems()) {
            ConsoleMassageService.getInstance()
                    .print(item.toString(), ConsoleMassageService.Color.PURPLE);
        }

        super.printTitle("Начать игру?");
        super.printMenu(menu);
        int selectedNumberUser = super.selectedNumberUser();
        super.selectItemMenu(menu, selectedNumberUser);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }
}

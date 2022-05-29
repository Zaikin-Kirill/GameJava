package menu;

import model.Item;
import model.SimpleItem;
import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;
import service.game.StepGame;
import service.io.ConsoleMassageService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StepSelectArtefactMenu extends MenuEntry {

    public StepSelectArtefactMenu() {
    }

    public StepSelectArtefactMenu(String title) {
        super(title);
    }

    private final List<MenuEntry> menu = new ArrayList<>();
    private int serialNumber = 1;

    @Override
    public void run() {

        StepGame.setHeroGamer(ChoiceUser.getHero());
        StepGame.setHeroComputer(ChoiceComputer.getHero());

        super.printTitle("Выберите артефакт:");
        for (Item item : ChoiceUser.getItems()) {
            ConsoleMassageService.getInstance()
                    .print(serialNumber + ". " + item.toString());
            serialNumber++;
        }

        addPoint(new MainMenu(serialNumber + ". " + "Вернуться в главное меню"));
        addPoint(new ExitMenu(serialNumber + ". " + "Выход"));

        super.printMenu(menu);
        selectOrJumpMenu();
    }

    private void selectOrJumpMenu() {
        try {
            int selectedNumberUser = super.selectedNumberUser();
            if (selectedNumberUser < ChoiceUser.getItems().size()) {
                StepGame.selectItemGamer(selectedNumberUser);
                StepGame.selectItemComputer();
                new StepSelectActionMenu().run();
            } else {
                super.selectItemMenu(menu, selectedNumberUser - ChoiceUser.getItems().size());
            }
        } catch (IndexOutOfBoundsException e) {
            ConsoleMassageService.getInstance().print("Введите число из диапазона меню");
            selectOrJumpMenu();
        }
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
        serialNumber++;
    }
}

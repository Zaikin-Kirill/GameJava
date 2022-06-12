package menu;

import java.util.ArrayList;
import java.util.List;
import service.game.GameService;


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

        new GameService().printAllInfo();

        super.printTitle("Начать игру?");
        super.printMenu(menu);
        int selectedNumberUser = super.selectedNumberUser();
        super.selectItemMenu(menu, selectedNumberUser);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }
}

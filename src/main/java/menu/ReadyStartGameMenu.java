package menu;

import service.game.GameService;


/**
 * Меню подтверждения начала игры.
 */
public class ReadyStartGameMenu extends MenuEntry {

    public ReadyStartGameMenu() {
    }


    @Override
    public void run() {
        addPoint(new StepSelectArtefactMenu(serialNumber + ". Да"));
        addPoint(new SelectHeroMenu(serialNumber + ". Вернуться в выбор персонажа"));
        addPoint(new ExitMenu(serialNumber + ". Выход"));

        new GameService().printAllInfo();

        super.printTitle("Начать игру?");
        super.printMenu(menu);
        int selectedNumberUser = super.selectedNumberUser(serialNumber);
        super.selectItemMenu(menu, selectedNumberUser);
    }

}

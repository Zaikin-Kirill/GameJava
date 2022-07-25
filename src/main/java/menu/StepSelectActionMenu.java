package menu;

import service.file.FileService;
import service.file.TextFileService;
import service.game.Action;
import service.game.StateStepGame;
import service.game.StepGame;
import service.io.ConsoleMassageService;


/**
 * Меню выбора действия на шаге игры.
 */
public class StepSelectActionMenu extends MenuEntry {


    /**
     * Сервис вывода на экран.
     */
    private final ConsoleMassageService consoleMassageService = ConsoleMassageService.getInstance();

    @Override
    public void run() {

        super.printTitle("Выберите действие:");
        for (Action action : Action.values()) {
            consoleMassageService.print(serialNumber + ". " + action.getName());
            serialNumber++;
        }

        addPoint(new MainMenu(serialNumber + ". " + "Вернуться в главное меню"));
        addPoint(new ExitMenu(serialNumber + ". " + "Выход"));

        super.printMenu(menu);
        selectOrJumpMenu();
    }

    private void selectOrJumpMenu() {
        try {
            int selectedNumberUser = super.selectedNumberUser(serialNumber);
            if (selectedNumberUser < Action.values().length) {
                StateStepGame stateStepGame = StateStepGame.getInstance();
                stateStepGame.selectActionGamer(selectedNumberUser);
                stateStepGame.selectActionComputer();
                StepGame stepGame = new StepGame();
                stepGame.printStepSelectGamer();
                stepGame.printStepSelectComputer();
                stepGame.fight();
                stepGame.printStepResult();
                if (stateStepGame.getHeroGamer().getHp() <= 0) {
                    consoleMassageService.print(
                            "Вы убиты в битве! Игра окончена!", ConsoleMassageService.Color.RED);
                    new TextFileService().deleteAllFilesFolder(FileService.saveDirectory);
                    new MainMenu().run();
                } else if (stateStepGame.getHeroComputer().getHp() <= 0) {
                    consoleMassageService.print(
                            "Компьютер убит в битве! Вы победили!", ConsoleMassageService.Color.GREEN);
                    new TextFileService().deleteAllFilesFolder(FileService.saveDirectory);
                    new MainMenu().run();
                } else {
                    new StepSelectArtefactMenu().run();
                }
            } else {
                super.selectItemMenu(menu, selectedNumberUser - Action.values().length);
            }
        } catch (IndexOutOfBoundsException e) {
            consoleMassageService.print("Введите число из диапазона меню");
            selectOrJumpMenu();
        }
    }

}

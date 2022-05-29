package menu;

import service.choiceitem.ChoiceUser;
import service.file.FileService;
import service.file.TextFileService;
import service.game.StepGame;
import service.io.ConsoleMassageService;

import java.util.ArrayList;
import java.util.List;

public class StepSelectActionMenu extends MenuEntry {

    private final List<MenuEntry> menu = new ArrayList<>();
    private final List<Integer> actionList = new ArrayList<>();
    private int serialNumber = 1;

    @Override
    public void run() {

        super.printTitle("Выберите действие:");
        for (StepGame.Action action : StepGame.Action.values()) {
            ConsoleMassageService.getInstance()
                    .print(serialNumber + ". " + action.getName());
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
            if (selectedNumberUser < StepGame.Action.values().length) {
                StepGame.selectActionGamer(selectedNumberUser);
                StepGame.selectActionComputer();
                StepGame.printStepSelectGamer();
                StepGame.printStepSelectComputer();
                StepGame.fight();
                StepGame.printStepResult();
                if (StepGame.getHeroGamer().getHp() <= 0) {
                    ConsoleMassageService.getInstance().print(
                            "Вы убиты в битве! Игра окончена!", ConsoleMassageService.Color.RED);
                    new TextFileService().deleteAllFilesFolder(FileService.saveDirectory);
                    new MainMenu().run();
                } else if (StepGame.getHeroComputer().getHp() <= 0) {
                    ConsoleMassageService.getInstance().print(
                            "Компьютер убит в битве! Вы победили!", ConsoleMassageService.Color.GREEN);
                    new TextFileService().deleteAllFilesFolder(FileService.saveDirectory);
                    new MainMenu().run();
                } else {
                    new StepSelectArtefactMenu().run();
                }

                //new StepSelectActionMenu().run();
            } else {
                super.selectItemMenu(menu, selectedNumberUser - StepGame.Action.values().length);
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

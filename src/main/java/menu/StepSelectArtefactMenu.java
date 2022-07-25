package menu;

import model.Item;
import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;
import service.game.LoadGame;
import service.game.StateStepGame;
import service.io.ConsoleMassageService;


/**
 * Меню выбора артефакта на шаге игры.
 */
public class StepSelectArtefactMenu extends MenuEntry {

    private boolean isloadGame = false;

    private final StateStepGame stateStepGame = StateStepGame.getInstance();

    /**
     * Сервис вывода на экран.
     */
    private final ConsoleMassageService consoleMassageService = ConsoleMassageService.getInstance();

    public StepSelectArtefactMenu() {
    }

    public StepSelectArtefactMenu(String title) {
        super(title);
    }

    public StepSelectArtefactMenu(String title, boolean isloadGame) {
        super(title);
        this.isloadGame = isloadGame;
    }

    @Override
    public void run() {

        if (isloadGame) {
            new LoadGame().loadSaveGame();
        }

        stateStepGame.setHeroGamer(ChoiceUser.getHero());
        stateStepGame.setHeroComputer(ChoiceComputer.getHero());

        super.printTitle("Выберите артефакт:");
        for (Item item : ChoiceUser.getItems()) {
            consoleMassageService.print(serialNumber + ". " + item.toString());
            serialNumber++;
        }

        addPoint(new MainMenu(serialNumber + ". Вернуться в главное меню"));
        addPoint(new ExitMenu(serialNumber + ". Выход"));

        super.printMenu(menu);
        selectOrJumpMenu();
    }

    private void selectOrJumpMenu() {
        try {
            int selectedNumberUser = super.selectedNumberUser(serialNumber);
            if (selectedNumberUser < ChoiceUser.getItems().size()) {
                stateStepGame.selectItemGamer(selectedNumberUser);
                stateStepGame.selectItemComputer();
                new StepSelectActionMenu().run();
            } else {
                super.selectItemMenu(menu, selectedNumberUser - ChoiceUser.getItems().size());
            }
        } catch (IndexOutOfBoundsException e) {
            consoleMassageService.print("Введите число из диапазона меню");
            selectOrJumpMenu();
        }
    }

}

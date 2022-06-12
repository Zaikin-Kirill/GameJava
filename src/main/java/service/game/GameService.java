package service.game;

import model.Item;
import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;
import service.io.ConsoleMassageService;

/**
 * Сервис помощи в игре.
 */
public class GameService {

    private static final ConsoleMassageService consoleMassageService = ConsoleMassageService.getInstance();

    /**
     * Печать полной сводной информации о героях и артефактах.
     */
    public void printAllInfo() {
        consoleMassageService.print("Ваш герой:", ConsoleMassageService.Color.GREEN);
        consoleMassageService.print(ChoiceUser.getHero().toString(), ConsoleMassageService.Color.GREEN);
        consoleMassageService.print("Ваши артефакты: ", ConsoleMassageService.Color.GREEN);
        for (Item item : ChoiceUser.getItems()) {
            consoleMassageService.print(item.toString(), ConsoleMassageService.Color.GREEN);
        }

        consoleMassageService.print("Герой компьютера:", ConsoleMassageService.Color.PURPLE);
        consoleMassageService.print(ChoiceComputer.getHero().toString(), ConsoleMassageService.Color.PURPLE);
        consoleMassageService.print("Артефакты компьютера: ", ConsoleMassageService.Color.PURPLE);
        for (Item item : ChoiceComputer.getItems()) {
            consoleMassageService.print(item.toString(), ConsoleMassageService.Color.PURPLE);
        }
    }
}

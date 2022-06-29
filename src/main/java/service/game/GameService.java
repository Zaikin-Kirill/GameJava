package service.game;

import model.Item;
import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;
import service.io.ConsoleMassageService;

import static service.io.ConsoleMassageService.Color.GREEN;
import static service.io.ConsoleMassageService.Color.PURPLE;

/**
 * Сервис помощи в игре.
 */
public class GameService {

    private static final ConsoleMassageService consoleMassageService = ConsoleMassageService.getInstance();

    /**
     * Печать полной сводной информации о героях и артефактах.
     */
    public void printAllInfo() {
        consoleMassageService.print("Ваш герой:", GREEN);
        consoleMassageService.print(ChoiceUser.getHero().toString(), GREEN);
        consoleMassageService.print("Ваши артефакты: ", GREEN);
        for (Item item : ChoiceUser.getItems()) {
            consoleMassageService.print(item.toString(), GREEN);
        }

        consoleMassageService.print("Герой компьютера:", PURPLE);
        consoleMassageService.print(ChoiceComputer.getHero().toString(), PURPLE);
        consoleMassageService.print("Артефакты компьютера: ", PURPLE);
        for (Item item : ChoiceComputer.getItems()) {
            consoleMassageService.print(item.toString(), PURPLE);
        }
    }
}

package service.choiceitem;

import java.io.IOException;
import java.util.List;
import model.Hero;
import model.Item;
import service.io.ConsoleMassageService;

/**
 * Выбор героя и артефактов пользователя.
 */
public class ChoiceUser extends ChoiceService {

    private static Hero heroGamer;
    private static List<Item> itemsGamer;

    public static Hero getHero() {
        return heroGamer;
    }

    public static List<Item> getItems() {
        return itemsGamer;
    }


    /**
     * Вызов сохранения в файл и вывод на экран выбранного героя пользователя.
     *
     * @param hero - герой пользователя
     */
    public void selectedHero(Hero hero) throws IOException {
        super.saveSelectedHero(hero, "heroGamer.json");
        heroGamer = hero;
        ConsoleMassageService.getInstance()
                .print("Вы выбрали героя:", ConsoleMassageService.Color.GREEN);
        ConsoleMassageService.getInstance()
                .print(hero.toString(), ConsoleMassageService.Color.GREEN);

    }

    /**
     * Вызов формирования и сохранения в файл артефактов
     * и вывод на экран выбранного артефакта пользователя.
     *
     * @param artefact - артефакт пользователя
     */
    public void selectedItem(Item artefact) throws IOException {
        itemsGamer = super.saveSelectedItem(artefact, itemsGamer, "itemGamer.json");
        int currentNumber = itemsGamer.lastIndexOf(artefact) + 1;
        ConsoleMassageService.getInstance()
                .print("Вы выбрали артефакт № " + currentNumber
                        + ":", ConsoleMassageService.Color.GREEN);
        ConsoleMassageService.getInstance()
                .print(artefact.toString(), ConsoleMassageService.Color.GREEN);
    }

}

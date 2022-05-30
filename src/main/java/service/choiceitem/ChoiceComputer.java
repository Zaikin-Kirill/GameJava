package service.choiceitem;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import model.Hero;
import model.Item;
import model.SimpleItem;
import service.file.FileService;
import service.io.ConsoleMassageService;

/**
 * Выбор героя и артефактов компьютера.
 */
public class ChoiceComputer extends ChoiceService {

    private static Hero heroComputer;

    private static List<Item> itemsComputer;

    public static Hero getHero() {
        return heroComputer;
    }

    public static List<Item> getItems() {
        return itemsComputer;
    }

    public static void setHeroComputer(Hero heroComputer) {
        ChoiceComputer.heroComputer = heroComputer;
    }

    public static void setItemsComputer(List<Item> itemsComputer) {
        ChoiceComputer.itemsComputer = itemsComputer;
    }

    /**
     * Вызов сохранения в файл и вывод на экран выбранного героя компьютера.
     *
     * @param hero - герой компьютера
     */
    public void selectedHero(Hero hero) throws IOException {
        super.saveSelectedHero(hero, FileService.saveHeroComputerFile);
        heroComputer = hero;
        ConsoleMassageService.getInstance()
                .print("Компьютер выбрал героя:", ConsoleMassageService.Color.PURPLE);
        ConsoleMassageService.getInstance()
                .print(hero.toString(), ConsoleMassageService.Color.PURPLE);

    }

    /**
     * Вызов формирования и сохранения в файл артефактов
     * и вывод на экран выбранного артефакта компьютера.
     *
     * @param artefact - артекфакт компьютера
     */
    public void selectedItem(Item artefact) throws IOException {
        itemsComputer = super.saveSelectedItem(artefact, itemsComputer, FileService.saveItemComputerFile);
        int currentNumber = itemsComputer.lastIndexOf(artefact) + 1;
        ConsoleMassageService.getInstance().print(
                "Компьютер выбрал артефакт № " + currentNumber
                        + ":", ConsoleMassageService.Color.PURPLE);
        ConsoleMassageService.getInstance()
                .print(artefact.toString(), ConsoleMassageService.Color.PURPLE);
    }

    public Hero getRandomHeroFromListWithoutUserHero(List<Hero> listAccessibleHero) {
        return listAccessibleHero.get(new Random().nextInt(listAccessibleHero.size()));
    }

    public Item getRandomItemFromListWithoutUserItems(List<Item> listAccessibleItem) {
        return listAccessibleItem.get(new Random().nextInt(listAccessibleItem.size()));
    }
}

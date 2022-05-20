package service.ChoiceItem;

import model.Hero;
import model.Item;
import model.SimpleItem;
import service.io.ConsoleMassageService;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ChoiceComputer extends ChoiceService{

    private static Hero heroComputer;
    private static List<Item> itemsComputer;

    public static Hero getHeroComputer() {
        return heroComputer;
    }

    public static List<Item> getItemsComputer() {
        return itemsComputer;
    }

    public void SelectedHero(Hero hero) throws IOException {
        super.saveSelectedHero(hero, "heroComputer.json");
        //new TextFileService().writeTextToFile("heroGamer.json", new JsonParserService().parseHeroToString(hero));
        heroComputer = hero;
        ConsoleMassageService.getInstance().print("Компьютер выбрал героя:");
        ConsoleMassageService.getInstance().print(hero.toString());

    }

    public void SelectedItem(Item artefact) throws IOException {
        itemsComputer = super.saveSelectedItem(artefact, itemsComputer, "itemComputer.json");
        int currentNumber = itemsComputer.lastIndexOf(artefact) + 1;
        ConsoleMassageService.getInstance().print("Компьютер выбрал артефакт № " + currentNumber + ":");
        ConsoleMassageService.getInstance().print(artefact.toString());
    }

    public Hero getRandomHeroFromListWithoutUserHero(List<Hero> listAccessibleHero){
        return listAccessibleHero.get(new Random().nextInt(listAccessibleHero.size()));
    }

    public SimpleItem getRandomItemFromListWithoutUserItems(List<SimpleItem> listAccessibleItem){
        return listAccessibleItem.get(new Random().nextInt(listAccessibleItem.size()));
    }
}

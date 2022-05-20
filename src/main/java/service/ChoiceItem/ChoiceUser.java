package service.ChoiceItem;

import model.Hero;
import model.Item;
import service.io.ConsoleMassageService;

import java.io.IOException;
import java.util.List;

public class ChoiceUser extends ChoiceService {

    private static Hero heroGamer;
    private static List<Item> itemsGamer;
//    private static final byte countItems = 2;

    public static Hero getHeroGamer() {
        return heroGamer;
    }

    public static List<Item> getItemsGamer() {
        return itemsGamer;
    }

//    public static byte getCountItems() {
//        return countItems;
//    }

    public void SelectedHero(Hero hero) throws IOException {
        super.saveSelectedHero(hero, "heroGamer.json");
        //new TextFileService().writeTextToFile("heroGamer.json", new JsonParserService().parseHeroToString(hero));
        heroGamer = hero;
        ConsoleMassageService.getInstance().print("Вы выбрали героя:");
        ConsoleMassageService.getInstance().print(hero.toString());

    }

    public void SelectedItem(Item artefact) throws IOException {
        itemsGamer = super.saveSelectedItem(artefact, itemsGamer, "itemGamer.json");
        int currentNumber = itemsGamer.lastIndexOf(artefact) + 1;
        ConsoleMassageService.getInstance().print("Вы выбрали артефакт № " + currentNumber + ":");
        ConsoleMassageService.getInstance().print(artefact.toString());
    }


//    public void saveSelectedSimpleItem(Item artefact) throws IOException {
////        new TextFileService().writeTextToFile("itemGamer.json", new JsonParserService().parceItemToString(artefact));
//        if (itemsGamer == null) {
//            createListItemsGamer();
//        }
//        if (itemsGamer.size() + 1 > countItems){
//            createListItemsGamer();
//        }
//        if (itemsGamer.size() == countItems) {
//            new TextFileService().writeTextToFile("itemGamer.json", new JsonParserService().parseListItemsToString(itemsGamer));
//        }
//
//        itemsGamer.add(artefact);
//        int currentNumber = itemsGamer.lastIndexOf(artefact) + 1;
//        ConsoleMassageService.getInstance().print("Вы выбрали артефакт № " + currentNumber + ":");
//        ConsoleMassageService.getInstance().print(artefact.toString());
//    }
//
//    private void createListItemsGamer(){
//        itemsGamer = new ArrayList<>(countItems);
//    }
}

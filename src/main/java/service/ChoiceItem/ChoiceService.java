package service.ChoiceItem;

import model.Hero;
import model.Item;
import service.file.TextFileService;
import service.io.ConsoleMassageService;
import service.parser.JsonParserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ChoiceService {

    private static final byte countItems = 2;

    public static byte getCountItems() {
        return countItems;
    }

    public void saveSelectedHero(Hero hero, String fileName) throws IOException {
        new TextFileService().writeTextToFile(fileName, new JsonParserService().parseHeroToString(hero));
    }

    public List<Item> saveSelectedItem(Item artefact, List<Item> listArtefact, String fileName) throws IOException {
        if (listArtefact == null) {
            listArtefact = createListItemsGamer();
        }
        if (listArtefact.size() + 1 > countItems){
            listArtefact = createListItemsGamer();
        }

        listArtefact.add(artefact);

        if (listArtefact.size() == countItems) {
            new TextFileService().writeTextToFile(fileName, new JsonParserService().parseListItemsToString(listArtefact));
        }

        return listArtefact;
    }

    private List<Item> createListItemsGamer(){
        return new ArrayList<>(countItems);
    }
}

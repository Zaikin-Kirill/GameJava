package service.parser;

import model.Hero;
import model.Item;
import model.SimpleItem;

import java.util.List;

public interface ParserService {

    List<Hero> getAllHeroFromString(String string);
    List<SimpleItem> getAllSimpleItemFromString(String string);

    String parseHeroToString(Hero hero);
    String parseItemToString(Item item);
    String parseListItemsToString(List<Item> items);

}

package service.parser;

import java.util.List;
import model.Hero;
import model.Item;

/**
 * Интерфейс парсинга.
 */
public interface ParserService {

    List<Hero> getAllHeroFromString(String string);

    Hero getHeroFromString(String string);

    List<Item> getAllSimpleItemFromString(String string);

    String parseHeroToString(Hero hero);

    String parseItemToString(Item item);

    String parseListItemsToString(List<Item> items);

}

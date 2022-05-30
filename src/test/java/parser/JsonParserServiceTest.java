package parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Hero;
import model.Item;
import model.SimpleItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.parser.JsonParserService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonParserServiceTest {

    @Test
    public void getAllHeroFromStringTest() {
        String str = "[{\"name\":\"Голем\",\"hp\":100.0,\"skillAttack\":0.1,\"skillDefense\":0.8}, {\"name\":\"Колдун\",\"hp\":100.0,\"skillAttack\":0.5,\"skillDefense\":0.6}]";
        List<Hero> assertTrue = new ArrayList<>();
        assertTrue.add(new Hero("Голем", 100, 0.1f, 0.8f));
        assertTrue.add(new Hero("Колдун", 100, 0.5f, 0.6f));
        JsonParserService _jsonParserService = new JsonParserService();
        List<Hero> result = _jsonParserService.getAllHeroFromString(str);
        Assertions.assertEquals(assertTrue, result);
    }

    @Test
    public void getAllSimpleItemFromStringTest() {
        String str = "[{\"damage\":3.0,\"defense\":1.0,\"name\":\"Тесак\"},{\"damage\":1.0,\"defense\":1.4,\"name\":\"Посох\"}]";
        List<Item> assertTrue = new ArrayList<>();
        assertTrue.add(new SimpleItem("Тесак", 3, 1));
        assertTrue.add(new SimpleItem("Посох", 1, 1.4f));
        JsonParserService _jsonParserService = new JsonParserService();
        List<Item> result = _jsonParserService.getAllSimpleItemFromString(str);
        Assertions.assertEquals(assertTrue, result);
    }

    @Test
    public void parseHeroToStringTest() {
        String assertTrue = "{\"name\":\"Голем\",\"hp\":100.0,\"skillAttack\":0.1,\"skillDefense\":0.8}";
        Hero hero = new Hero("Голем", 100, 0.1f, 0.8f);
        JsonParserService _jsonParserService = new JsonParserService();
        String result = _jsonParserService.parseHeroToString(hero);
        Assertions.assertEquals(assertTrue, result);
    }

    @Test
    public void parseItemToStringTest() {
        String assertTrue = "{\"damage\":3.0,\"defense\":1.0,\"name\":\"Тесак\"}";
        Item item = new SimpleItem("Тесак", 3, 1);
        JsonParserService _jsonParserService = new JsonParserService();
        String result = _jsonParserService.parseItemToString(item);
        Assertions.assertEquals(assertTrue, result);
    }

    @Test
    public void parseListItemsToString() {
        String assertTrue = "[{\"damage\":3.0,\"defense\":1.0,\"name\":\"Тесак\"},{\"damage\":1.0,\"defense\":1.4,\"name\":\"Посох\"}]";
        List<Item> items = new ArrayList<>();
        items.add(new SimpleItem("Тесак", 3, 1));
        items.add(new SimpleItem("Посох", 1, 1.4f));
        JsonParserService _jsonParserService = new JsonParserService();
        String result = _jsonParserService.parseListItemsToString(items);
        Assertions.assertEquals(assertTrue, result);
    }


}

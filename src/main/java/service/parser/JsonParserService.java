package service.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Hero;
import model.Item;
import model.SimpleItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonParserService implements ParserService {
    @Override
    public List<Hero> getAllHeroFromString(String string) {
        Type heroListType = new TypeToken<ArrayList<Hero>>() {
        }.getType();
        return new Gson().fromJson(string, heroListType);
    }

    @Override
    public List<SimpleItem> getAllSimpleItemFromString(String string) {
        Type simpleItemListType = new TypeToken<ArrayList<SimpleItem>>() {
        }.getType();
        return new Gson().fromJson(string, simpleItemListType);
    }

    @Override
    public String parseHeroToString(Hero hero) {
        return new Gson().toJson(hero);
    }

    @Override
    public String parseItemToString(Item item) {
        return new Gson().toJson(item);
    }

    @Override
    public String parseListItemsToString(List<Item> items) {
        return new Gson().toJson(items);
    }
}

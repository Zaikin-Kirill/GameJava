package Service.File;

import Model.Hero;
import Model.Item;
import Model.SimpleItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonFileService implements FileService {

    //private final String directory = "src/main/resources/";

    public List<Hero> getAllHero(String fileName) throws FileNotFoundException {
        Type heroListType = new TypeToken<ArrayList<Hero>>() {
        }.getType();
        return new Gson().fromJson(new BufferedReader(new FileReader(directory + fileName)), heroListType);
    }

    public List<SimpleItem> getAllSimpleItem(String fileName) throws FileNotFoundException {
        Type simpleItemListType = new TypeToken<ArrayList<SimpleItem>>() {
        }.getType();
        return new Gson().fromJson(new BufferedReader(new FileReader(directory + fileName)), simpleItemListType);
    }

    @Override
    public String getRulesFromTXT(String fileName) {
        return null;
    }

    public void setAllSimpleItem(String fileName) throws IOException {
        List<Item> list = new ArrayList<>();
        list.add(new SimpleItem("Axe", 2.5f, 1f));
        list.add(new SimpleItem("Onion", 3f, 1f));
        list.add(new SimpleItem("Helmet", 0.5f, 3f));
        list.add(new SimpleItem("Armor", 1f, 5f));

        try (Writer writer = new FileWriter(directory + fileName)) {
            new Gson().toJson(list, writer);
        }
    }

    public void setAllHero(String fileName) throws IOException {
        List<Hero> list = new ArrayList<>();
        list.add(new Hero("Dwarf", 0.1f, 0.2f));
        list.add(new Hero("Troll", 0.3f, 0.3f));
        list.add(new Hero("Golem", 0.5f, 0.5f));
        list.add(new Hero("Witch", 0.3f, 0.1f));
        try (Writer writer = new FileWriter(directory + fileName)) {
            new Gson().toJson(list, writer);
        }
    }

}

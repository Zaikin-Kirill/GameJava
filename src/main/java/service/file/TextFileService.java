package service.file;

import model.Hero;
import model.Item;
import model.SimpleItem;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileService implements FileService {

    public String readTextFromFile(String fileName) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(directory + fileName))) {
            String str;
            while ((str = br.readLine()) != null) {
                text.append(str);
            }
            return text.toString();
        }
    }


//    public void setAllSimpleItem(String fileName) throws IOException {
//        List<Item> list = new ArrayList<>();
//        list.add(new SimpleItem("Axe", 2.5f, 1f));
//        list.add(new SimpleItem("Onion", 3f, 1f));
//        list.add(new SimpleItem("Helmet", 0.5f, 3f));
//        list.add(new SimpleItem("Armor", 1f, 5f));
//
//        try (Writer writer = new FileWriter(directory + fileName)) {
//            new Gson().toJson(list, writer);
//        }
//    }
//
//    public void setAllHero(String fileName) throws IOException {
//        List<Hero> list = new ArrayList<>();
//        list.add(new Hero("Dwarf", 0.1f, 0.2f));
//        list.add(new Hero("Troll", 0.3f, 0.3f));
//        list.add(new Hero("Golem", 0.5f, 0.5f));
//        list.add(new Hero("Witch", 0.3f, 0.1f));
//        try (Writer writer = new FileWriter(directory + fileName)) {
//            new Gson().toJson(list, writer);
//        }
//    }

}

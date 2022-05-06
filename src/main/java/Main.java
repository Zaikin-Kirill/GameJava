import Model.Hero;
import Model.Item;
import Model.SimpleItem;
import Service.File.FileService;
import Service.File.JsonFileService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("aaa");
        FileService fileService = new JsonFileService();

        try {
            List<Hero> list = fileService.getAllHero("hero.json");
            for (Hero hero : list) {
                System.out.println(hero);
            }

        } catch (IOException ignored) {

        }

//        try {
//            fileService.setAllSimpleItem("item.json");
//        } catch (IOException ignored) {
//
//        }

        try {
            List<SimpleItem> list = fileService.getAllSimpleItem("item.json");
            for (SimpleItem item : list) {
                System.out.println(item);
            }
        } catch (IOException ignored) {

        }

//        try {
//            fileService.setAllHero();
//        } catch (IOException ignored) {
//            System.out.println(ignored.getMessage());
//        }
    }
}
import menu.MainMenu;
import model.Hero;
import model.SimpleItem;
import service.file.FileService;
import service.file.TextFileService;
import service.parser.JsonParserService;
import service.parser.ParserService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        new MainMenu().run();


        /*ParserService parserService = new JsonParserService();
        FileService fileService = new TextFileService();

        try {
            List<Hero> list = parserService.getAllHeroFromString(fileService.readTextFromFile("hero.json"));
            for (Hero hero : list) {
                System.out.println(hero);
            }
        } catch (IOException ignored) {

        }

//        try {
//            parserService.setAllSimpleItem("item.json");
//        } catch (IOException ignored) {
//
//        }

        try {
            List<SimpleItem> list = parserService.getAllSimpleItemFromString(fileService.readTextFromFile("item.json"));
            for (SimpleItem item : list) {
                System.out.println(item);
            }
        } catch (IOException ignored) {

        }*/

    }
}
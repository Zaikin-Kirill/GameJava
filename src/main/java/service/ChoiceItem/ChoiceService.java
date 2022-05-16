package service.ChoiceItem;

import model.Hero;
import model.SimpleItem;
import service.IO.ConsoleMassageService;

public class ChoiceService {

    public <T> void saveSelected(T item){
        //сохранение в файл

        if (item instanceof Hero hero){
            ConsoleMassageService.getInstance().print("Вы выбрали героя:");
            ConsoleMassageService.getInstance().print(hero.toString());
        }
        else if (item instanceof SimpleItem simpleItem) {
            ConsoleMassageService.getInstance().print("Вы выбрали артефакт:");
            ConsoleMassageService.getInstance().print(simpleItem.toString());
        }

    }
}

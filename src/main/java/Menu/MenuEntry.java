package Menu;

import Service.IO.ConsoleMassageService;

import java.io.IOException;
import java.util.List;

public class MenuEntry {

    private String title;

    public MenuEntry(){
    }

    public MenuEntry(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void run(){}

    public void printTitle(String titleText) {
        new ConsoleMassageService().print(titleText);
    }

    public void PrintMenu(List<MenuEntry> menu) {
        ConsoleMassageService console = new ConsoleMassageService();
        for (MenuEntry point: menu) {
            console.print(point.getTitle());
        }
    }

    public void selectItemMenu(List<MenuEntry> menu){
        try {
            int inputNumber = new ConsoleMassageService().inputNumber();
            menu.get(inputNumber).run();
        } catch (IOException e) {
            new ConsoleMassageService().print(e.getMessage());
            selectItemMenu(menu);
        } catch (IndexOutOfBoundsException e){
            new ConsoleMassageService().print("Введите число из диапазона меню");
            selectItemMenu(menu);
        }
    }
}

package menu;

import service.IO.ConsoleMassageService;

import java.io.IOException;
import java.util.List;

public abstract class MenuEntry {

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

    public abstract void run();

    public void printTitle(String titleText) {
        ConsoleMassageService.getInstance().print(titleText);
    }

    public void printMenu(List<MenuEntry> menu) {

        for (MenuEntry point: menu) {
            ConsoleMassageService.getInstance().print(point.getTitle());
        }
    }

    public void selectItemMenu(List<MenuEntry> menu){
        try {
            int inputNumber = ConsoleMassageService.getInstance().inputNumber();
            menu.get(inputNumber).run();
        } catch (IOException e) {
            ConsoleMassageService.getInstance().print(e.getMessage());
            selectItemMenu(menu);
        } catch (IndexOutOfBoundsException e){
            ConsoleMassageService.getInstance().print("Введите число из диапазона меню");
            selectItemMenu(menu);
        }
    }
}

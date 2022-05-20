package menu;

import service.io.ConsoleMassageService;

import java.io.IOException;
import java.util.List;

public abstract class MenuEntry {

    private String title;

    public MenuEntry() {
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

        for (MenuEntry point : menu) {
            ConsoleMassageService.getInstance().print(point.getTitle());
        }
    }

    public int selectedNumberUser() {
        int inputNumber = -1;
        try {
            inputNumber = ConsoleMassageService.getInstance().inputNumber();
        } catch (IOException e) {
            ConsoleMassageService.getInstance().print(e.getMessage());
            selectedNumberUser();
        }
        return inputNumber;
    }


    public void selectItemMenu(List<MenuEntry> menu, int indexMenu) throws IndexOutOfBoundsException {
        menu.get(indexMenu).run();
//        try {
//            menu.get(indexMenu).run();
//        } catch (IndexOutOfBoundsException e) {
//            ConsoleMassageService.getInstance().print("Введите число из диапазона меню");
//            selectItemMenu(menu, selectedNumberUser());
//        }
    }

//    public <T> void selectItemMenuWithSelectHero(List<MenuEntry> menu, List<T> listT){
//        try {
//            int inputNumber = ConsoleMassageService.getInstance().inputNumber();
//            int sizeListT = listT.size();
//            if (inputNumber < sizeListT){
//                new ChoiceService().saveSelected(listT.get(inputNumber));
//                if (!listT.isEmpty() && listT.get(0).getClass() == Hero.class){
//                    new SelectArtefactMenu().run();
//                }
//                else if (!listT.isEmpty() && listT.get(0).getClass() == SimpleItem.class){
//                    new StartGameMenu().run();
//                }
//            } else {
//                menu.get(inputNumber - sizeListT).run();
//            }
//        } catch (IOException e) {
//            ConsoleMassageService.getInstance().print(e.getMessage());
//            selectItemMenuWithSelectHero(menu, listT);
//        } catch (IndexOutOfBoundsException e){
//            ConsoleMassageService.getInstance().print("Введите число из диапазона меню");
//            selectItemMenuWithSelectHero(menu, listT);
//        }
//    }
}

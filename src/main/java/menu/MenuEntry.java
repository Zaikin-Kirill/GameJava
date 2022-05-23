package menu;

import java.io.IOException;
import java.util.List;
import service.io.ConsoleMassageService;

/**
 * Абстрактный класс меню.
 */
public abstract class MenuEntry {

    /**
     * Заголовок меню.
     */
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

    /**
     * Вывод на экран начального текста.
     *
     * @param titleText  - текст для вывода
     */
    public void printTitle(String titleText) {
        ConsoleMassageService.getInstance().print(titleText);
    }

    /**
     * Вывод на экран заголовков меню.
     *
     * @param menu - список меню
     */
    public void printMenu(List<MenuEntry> menu) {

        for (MenuEntry point : menu) {
            ConsoleMassageService.getInstance().print(point.getTitle());
        }
    }

    /**
     * Получение введенной пользователем цифры.
     *
     * @return выбранная пользователем цифра
     */
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


    public void selectItemMenu(List<MenuEntry> menu, int indexMenu)
            throws IndexOutOfBoundsException {
        menu.get(indexMenu).run();
    }
}

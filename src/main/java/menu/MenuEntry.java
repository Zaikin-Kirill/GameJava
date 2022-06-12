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

    /**
     * Сервис вывода на экран.
     */
    private final ConsoleMassageService consoleMassageService = ConsoleMassageService.getInstance();

    public MenuEntry() {
    }

    public MenuEntry(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void run();

    /**
     * Вывод на экран начального текста.
     *
     * @param titleText  - текст для вывода
     */
    public void printTitle(String titleText) {
        consoleMassageService.print(titleText);
    }

    /**
     * Вывод на экран заголовков меню.
     *
     * @param menu - список меню
     */
    public void printMenu(List<MenuEntry> menu) {

        for (MenuEntry point : menu) {
            consoleMassageService.print(point.getTitle());
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
            inputNumber = consoleMassageService.inputNumber();
        } catch (IOException e) {
            consoleMassageService.print(e.getMessage());
            selectedNumberUser();
        }
        return inputNumber;
    }


    public void selectItemMenu(List<MenuEntry> menu, int indexMenu)
            throws IndexOutOfBoundsException {
        menu.get(indexMenu).run();
    }
}

package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import service.io.ConsoleMassageService;

/**
 * Абстрактный класс меню.
 */
public abstract class MenuEntry {

    protected final List<MenuEntry> menu = new ArrayList<>();
    protected int serialNumber = 1;

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
     * @param titleText - текст для вывода
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
    public int selectedNumberUser(int maxNumber) {
        int inputNumber = -1;
        while (inputNumber < 1 || inputNumber > maxNumber) {
            try {
                inputNumber = consoleMassageService.inputNumber();
                if (inputNumber < 1 || inputNumber > maxNumber) {
                    consoleMassageService.print(String.format(
                            "Введите число в диапазоне от %d до %d", 1, maxNumber - 1));
                }
            } catch (IOException e) {
                consoleMassageService.print(e.getMessage());
            }
        }
        return (inputNumber - 1);
    }


    public void selectItemMenu(List<MenuEntry> menu, int indexMenu)
            throws IndexOutOfBoundsException {
        menu.get(indexMenu).run();
    }

    protected void addPoint(MenuEntry entry) {
        menu.add(entry);
        serialNumber++;
    }
}

package service.io;

import java.io.IOException;
import java.util.Scanner;

/**
 * Класс ввода-вывода в консоль.
 */
public class ConsoleMassageService implements MessageService {

    /**
     * Перечисление цветов текста.
     */
    public enum Color {
        PURPLE("\u001B[35m"),
        GREEN("\u001B[32m"),
        RED("\u001B[31m"),
        RESET("\u001B[0m");

        private final String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    private static ConsoleMassageService INSTANCE;

    private ConsoleMassageService() {
    }

    /**
     * Получение ссылки на ConsoleMassageService.
     *
     * @return - ConsoleMassageService
     */
    public static ConsoleMassageService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConsoleMassageService();
        }
        return INSTANCE;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void print(String text, Color color) {
        System.out.println(color.getCode() + text + Color.RESET.getCode());
    }

    @Override
    public int inputNumber() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int i;
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
        } else {
            throw new IOException("Вы ввели не число");
        }
        return i;
    }
}

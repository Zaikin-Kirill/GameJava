package service.io;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleMassageService implements MassageService {

    private static ConsoleMassageService INSTANCE;

    private ConsoleMassageService() {}

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
    public int inputNumber() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int i;
        if (scanner.hasNextInt()) {
            i = scanner.nextInt() - 1;
        } else {
            throw new IOException("Вы ввели не число");
        }
        return i;
    }
}

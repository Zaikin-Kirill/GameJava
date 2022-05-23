package service.io;

import java.io.IOException;

/**
 * Интерфейс ввода-вывода.
 */
public interface MessageService {

    void print(String text);

    void print(String text, ConsoleMassageService.Color color);

    int inputNumber() throws IOException;
}

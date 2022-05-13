package service.IO;

import java.io.IOException;

public interface MassageService {
    void print(String text);
    int inputNumber() throws IOException;
}

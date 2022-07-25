package menu;

import java.io.IOException;
import service.file.FileService;
import service.file.TextFileService;
import service.io.ConsoleMassageService;

/**
 * Меню правил игры.
 */
public class RuleMenu extends MenuEntry {


    public RuleMenu(String title) {
        super(title);
    }


    @Override
    public void run() {
        addPoint(new MainMenu(serialNumber + ". Вернуться в меню"));
        addPoint(new ExitMenu(serialNumber + ". Выход"));
        super.printTitle("Правила игры:");
        printTextRules();
        super.printMenu(menu);
        int selectedNumberUser = super.selectedNumberUser(serialNumber);
        super.selectItemMenu(menu, selectedNumberUser);
    }

    private void printTextRules() {
        try {
            ConsoleMassageService.getInstance()
                    .print(new TextFileService()
                            .readTextFromFile(FileService.readDirectory, "rules.txt"));
        } catch (IOException e) {
            ConsoleMassageService.getInstance().print(e.getMessage());
        }
    }
}

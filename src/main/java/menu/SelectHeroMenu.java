package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Hero;
import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;
import service.file.FileService;
import service.file.TextFileService;
import service.io.ConsoleMassageService;
import service.parser.JsonParserService;


/**
 * Меню выбора героя.
 */
public class SelectHeroMenu extends MenuEntry {


    /**
     * Сервис вывода на экран.
     */
    private final ConsoleMassageService consoleMassageService = ConsoleMassageService.getInstance();

    public SelectHeroMenu(String title) {
        super(title);
    }

    @Override
    public void run() {
        super.printTitle("Выберите персонажа:");
        List<Hero> listHero = new ArrayList<>();
        try {
            listHero = new JsonParserService().getAllHeroFromString(
                    new TextFileService().readTextFromFile(FileService.readDirectory, "hero.json"));
            for (Hero hero : listHero) {
                super.printTitle(serialNumber + ". " + hero.getType());
                serialNumber++;
            }
        } catch (IOException mes) {
            super.printTitle(mes.getMessage());
        }

        addPoint(new MainMenu(serialNumber + ". " + "Вернуться главное в меню"));
        addPoint(new ExitMenu(serialNumber + ". " + "Выход"));

        super.printMenu(menu);
        selectOrJumpMenu(listHero);

    }

    private void selectOrJumpMenu(List<Hero> listHero) {
        try {
            int selectedNumberUser = super.selectedNumberUser(serialNumber);
            if (selectedNumberUser < listHero.size()) {
                selectHero(listHero, selectedNumberUser);
            } else {
                super.selectItemMenu(menu, selectedNumberUser - listHero.size());
            }
        } catch (IndexOutOfBoundsException e) {
            consoleMassageService.print("Введите число из диапазона меню");
            selectOrJumpMenu(listHero);
        }
    }

    private void selectHero(List<Hero> listHero, int indexSelected) {
        try {
            new ChoiceUser().selectedHero(listHero.get(indexSelected));
            doChoiceHeroComputer(listHero);
            new SelectArtefactMenu().run();
        } catch (IOException mes) {
            consoleMassageService.print(mes.getMessage());
            selectOrJumpMenu(listHero);
        }
    }

    private void doChoiceHeroComputer(List<Hero> listHero) {
        listHero.remove(ChoiceUser.getHero());
        ChoiceComputer choiceComputer = new ChoiceComputer();
        try {
            choiceComputer.selectedHero(
                    choiceComputer.getRandomHeroFromListWithoutUserHero(listHero));
        } catch (IOException mes) {
            consoleMassageService.print(mes.getMessage());
        }
    }


}

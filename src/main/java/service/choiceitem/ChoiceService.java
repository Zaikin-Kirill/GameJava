package service.choiceitem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Hero;
import model.Item;
import service.file.FileService;
import service.file.TextFileService;
import service.parser.JsonParserService;

/**
 * Абстрактный класс выбора героя и артефактов.
 */
public abstract class ChoiceService {

    private final byte countItems = 2;

    public byte getCountItems() {
        return countItems;
    }

    /**
     * Вызов парсинга в json и записи героя в файл.
     *
     * @param hero - выбранный герой
     * @param fileName - имя файла для сохранения героя
     */
    public void saveSelectedHero(Hero hero, String fileName) throws IOException {
        new TextFileService().writeTextToFile(
                FileService.saveDirectory, fileName,
                new JsonParserService().parseHeroToString(hero));
    }

    /**
     * Формирование списка артефактов, вызов парсинга в json
     * и записи в файл.
     *
     * @param artefact     - новый артефакт {@link Item}
     * @param listArtefact - список уже выбранных артефактов
     * @param fileName     - имя файла для сохранения артефактов
     * @return - новый список артефактов
     */
    public List<Item> saveSelectedItem(Item artefact, List<Item> listArtefact, String fileName)
            throws IOException {
        if (listArtefact == null) {
            listArtefact = createListItemsGamer();
        }
        if (listArtefact.size() + 1 > countItems) {
            listArtefact = createListItemsGamer();
        }

        listArtefact.add(artefact);

        if (listArtefact.size() == countItems) {
            new TextFileService().writeTextToFile(
                    FileService.saveDirectory, fileName,
                    new JsonParserService().parseListItemsToString(listArtefact));
        }

        return listArtefact;
    }

    private List<Item> createListItemsGamer() {
        return new ArrayList<>(countItems);
    }

}

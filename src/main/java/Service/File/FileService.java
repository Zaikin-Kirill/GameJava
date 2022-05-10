package Service.File;

import Model.Hero;
import Model.SimpleItem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {

    public final String directory = "src/main/resources/";

    List<Hero> getAllHero(String fileName) throws FileNotFoundException;
    void setAllHero(String fileName) throws IOException;

    void setAllSimpleItem(String fileName) throws IOException;
    List<SimpleItem> getAllSimpleItem(String fileName) throws FileNotFoundException;

    String getRulesFromTXT(String fileName);
}

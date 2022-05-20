package service.file;

import java.io.IOException;

public interface FileService {

    String readDirectory = "src/main/resources/";
    String saveDirectory = "src/main/resources/savegame/";

    String readTextFromFile(String fileName) throws IOException;

    void writeTextToFile(String fileName, String text) throws IOException;

//    void setAllHero(String fileName) throws IOException;
//    void setAllSimpleItem(String fileName) throws IOException;


    //String getAllSimpleItem(String fileName) throws FileNotFoundException;
    //String getContentAsString(String fileName);
}

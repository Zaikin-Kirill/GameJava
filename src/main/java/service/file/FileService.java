package service.file;

import model.Hero;
import model.SimpleItem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {

    String directory = "src/main/resources/";

    String readTextFromFile(String fileName) throws IOException;

//    void setAllHero(String fileName) throws IOException;
//    void setAllSimpleItem(String fileName) throws IOException;


    //String getAllSimpleItem(String fileName) throws FileNotFoundException;
    //String getContentAsString(String fileName);
}

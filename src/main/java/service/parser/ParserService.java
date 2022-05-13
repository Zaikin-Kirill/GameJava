package service.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Hero;
import model.SimpleItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public interface ParserService {

    List<Hero> getAllHeroFromString(String string);
    List<SimpleItem> getAllSimpleItemFromString(String string);

}

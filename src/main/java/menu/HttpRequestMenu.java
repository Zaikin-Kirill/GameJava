package menu;

import service.io.ConsoleMassageService;
import service.parser.JsonParserService;
import service.webapi.HttpApiService;

import java.util.ArrayList;
import java.util.List;

public class HttpRequestMenu extends MenuEntry {

    public HttpRequestMenu(String title) {
        super(title);
    }

    private final List<MenuEntry> menu = new ArrayList<>();

    @Override
    public void run() {
        String targetUrlAnimal = "https://random-word-form.herokuapp.com/random/animal";
        String targetUrlAdjective = "https://random-word-form.herokuapp.com/random/adjective";

        addPoint(new MainMenu("1. Вернуться в меню"));
        addPoint(new ExitMenu("2. Выход"));
        super.printTitle("Результат запроса:");
        for (int i = 0; i < 2; i++) {
            ConsoleMassageService.getInstance().
                    print(getRequestRandomWord(targetUrlAdjective)
                            + " "
                            + getRequestRandomWord(targetUrlAnimal));
        }

        super.printMenu(menu);
        int selectedNumberUser = super.selectedNumberUser();
        super.selectItemMenu(menu, selectedNumberUser);
    }

    private void addPoint(MenuEntry entry) {
        menu.add(entry);
    }

    private String getRequestRandomWord(String targetUrl) {
        HttpApiService httpService = new HttpApiService();
        StringBuilder response = httpService.sendGetRequest(targetUrl);
        if (response != null) {
            String[] arrayString = new JsonParserService().getArrayStringFromJsonString(response.toString());
            return arrayString[0];
        }
        return "";
    }
}

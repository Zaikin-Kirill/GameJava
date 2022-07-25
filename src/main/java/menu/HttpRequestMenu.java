package menu;

import service.builder.NameBuilderService;
import service.io.ConsoleMassageService;


public class HttpRequestMenu extends MenuEntry {

    public HttpRequestMenu(String title) {
        super(title);
    }

    private static final String BASE_URL = "https://random-word-form.herokuapp.com/random";

    @Override
    public void run() {
        final int countName = 2;
        String targetUrlAnimal = BASE_URL + "/animal";
        String targetUrlAdjective = BASE_URL + "/adjective";
        NameBuilderService nameBuilderService = new NameBuilderService();

        addPoint(new MainMenu(serialNumber + ". Вернуться в меню"));
        addPoint(new ExitMenu(serialNumber + ". Выход"));
        super.printTitle("Результат запроса:");
        for (int i = 0; i < countName; i++) {
            ConsoleMassageService.getInstance().
                    print(String.format("%s %s",
                            nameBuilderService.getRequestRandomWord(targetUrlAdjective),
                            nameBuilderService.getRequestRandomWord(targetUrlAnimal)));
        }

        super.printMenu(menu);
        int selectedNumberUser = super.selectedNumberUser(serialNumber);
        super.selectItemMenu(menu, selectedNumberUser);
    }


}

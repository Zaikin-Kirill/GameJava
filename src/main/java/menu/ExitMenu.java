package menu;

public class ExitMenu extends MenuEntry {


    public ExitMenu(String title) {
        super(title);
    }

    @Override
    public void run(){
        super.printTitle("До новых встреч!");
        System.exit(0);
    }
}

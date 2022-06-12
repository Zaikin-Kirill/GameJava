package service.game;

import java.util.Random;
import model.Hero;
import model.Item;
import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;


/**
 * Хранит состояние игры. Синглтон.
 */
public class StateStepGame {

    private static StateStepGame INSTANCE;

    private StateStepGame() {
    }

    /**
     * Получение ссылки на StateStepGame.
     *
     * @return - StateStepGame
     */
    public static StateStepGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StateStepGame();
        }
        return INSTANCE;
    }

    private Hero heroGamer;
    private Item itemsGamer;
    private Action actionGamer;

    private Hero heroComputer;
    private Item itemsComputer;
    private Action actionComputer;

    public Hero getHeroGamer() {
        return heroGamer;
    }

    public void setHeroGamer(Hero heroGamer) {
        this.heroGamer = heroGamer;
    }

    public Hero getHeroComputer() {
        return heroComputer;
    }

    public void setHeroComputer(Hero heroComputer) {
        this.heroComputer = heroComputer;
    }

    public void setItemsGamer(Item itemsGamer) {
        this.itemsGamer = itemsGamer;
    }

    public void setItemsComputer(Item itemsComputer) {
        this.itemsComputer = itemsComputer;
    }


    public void selectItemGamer(int indexSelected) {
        itemsGamer = ChoiceUser.getItems().get(indexSelected);
    }

    public void selectItemComputer() {
        itemsComputer = ChoiceComputer.getItems().get(new Random().nextInt(ChoiceComputer.getItems().size()));
    }

    public void selectActionGamer(int indexSelected) {
        actionGamer = Action.values()[indexSelected];
    }

    public void selectActionComputer() {
        actionComputer = Action.values()[new Random().nextInt(Action.values().length)];
    }


    public Item getItemsGamer() {
        return itemsGamer;
    }

    public Item getItemsComputer() {
        return itemsComputer;
    }

    public Action getActionComputer() {
        return actionComputer;
    }

    public Action getActionGamer() {
        return actionGamer;
    }
}

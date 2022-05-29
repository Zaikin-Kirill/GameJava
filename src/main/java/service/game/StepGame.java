package service.game;

import model.Hero;
import model.Item;
import model.SimpleItem;
import service.choiceitem.ChoiceComputer;
import service.choiceitem.ChoiceUser;
import service.file.FileService;
import service.file.TextFileService;
import service.io.ConsoleMassageService;
import service.parser.JsonParserService;

import java.io.IOException;
import java.util.Random;

public class StepGame {

    public enum Action {
        ATTACK("Атака"),
        DEFENSE("Защита");

        private final String name;

        Action(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static Hero heroGamer;
    private static Item itemGamer;
    private static Action actionGamer;

    private static Hero heroComputer;
    private static Item itemsComputer;
    private static Action actionComputer;

    public static Hero getHeroGamer() {
        return heroGamer;
    }

    public static void setHeroGamer(Hero heroGamer) {
        StepGame.heroGamer = heroGamer;
    }

    public static Hero getHeroComputer() {
        return heroComputer;
    }

    public static void setHeroComputer(Hero heroComputer) {
        StepGame.heroComputer = heroComputer;
    }

    public static void selectItemGamer(int indexSelected) {
        itemGamer = ChoiceUser.getItems().get(indexSelected);
    }

    public static void selectItemComputer() {
        itemsComputer = ChoiceComputer.getItems().get(new Random().nextInt(ChoiceComputer.getItems().size()));
    }

    public static void selectActionGamer(int indexSelected) {
        actionGamer = Action.values()[indexSelected];
    }

    public static void selectActionComputer() {
        actionComputer = Action.values()[new Random().nextInt(Action.values().length)];
    }

    public static void printStepSelectGamer() {
        ConsoleMassageService.getInstance().print(
                "Вы выбрали: "
                        + itemGamer.toString() + ". Действие: "
                        + actionGamer.getName(), ConsoleMassageService.Color.GREEN);
    }

    public static void printStepSelectComputer() {
        ConsoleMassageService.getInstance().print(
                "Компьютер выбрал: "
                        + itemsComputer.toString() + ". Действие: "
                        + actionComputer.getName(), ConsoleMassageService.Color.PURPLE);
    }

    public static void printStepResult() {
        ConsoleMassageService.getInstance().print("Результаты битвы:");
        ConsoleMassageService.getInstance().print("Осталось жизней у вас: " + heroGamer.getHp());
        ConsoleMassageService.getInstance().print("Осталось жизней у компьютера: " + heroComputer.getHp());
    }

    private static void saveStepResult() {
        try {
            new TextFileService().writeTextToFile(FileService.saveDirectory, "heroGamer.json",
                    new JsonParserService().parseHeroToString(heroGamer));
            new TextFileService().writeTextToFile(FileService.saveDirectory, "heroComputer.json",
                    new JsonParserService().parseHeroToString(heroComputer));
        } catch (IOException e) {
            ConsoleMassageService.getInstance().print(e.getMessage());
        }
    }

    public static void fight() {
        switch (actionGamer) {
            case ATTACK -> {
                float attackGamer = 0;
                if (itemGamer instanceof SimpleItem) {
                    float randomAttackGamer = getRandom0to1();
                    attackGamer = heroGamer.getSkillAttack() * ((SimpleItem) itemGamer).getDamage() * randomAttackGamer;
                }
                switch (actionComputer) {
                    case ATTACK -> {
                        float attackComputer = 0;
                        if (itemsComputer instanceof SimpleItem) {
                            float randomAttackComp = getRandom0to1();
                            attackComputer = heroComputer.getSkillAttack() * ((SimpleItem) itemsComputer).getDamage()
                                    * randomAttackComp;
                        }
                        heroComputer.setHp(heroComputer.getHp() - attackGamer);
                        heroGamer.setHp(heroGamer.getHp() - attackComputer);
                    }
                    case DEFENSE -> {
                        float defenseComputer = 0;
                        if (itemsComputer instanceof SimpleItem) {
                            float randomDefenseComp = getRandom0to1();
                            defenseComputer = heroComputer.getSkillDefense() * ((SimpleItem) itemsComputer).getDefense()
                                    * randomDefenseComp;
                        }
                        if (attackGamer > defenseComputer) {
                            heroComputer.setHp(heroComputer.getHp() - (attackGamer - defenseComputer));
                        }
                    }
                }
            }
            case DEFENSE -> {
                float defenseGamer = 0;
                if (itemGamer instanceof SimpleItem) {
                    float randomDefenseGamer = getRandom0to1();
                    defenseGamer = heroGamer.getSkillDefense() * ((SimpleItem) itemGamer).getDefense()
                            * randomDefenseGamer;
                }
                switch (actionComputer) {
                    case ATTACK:
                        float attackComputer = 0;
                        if (itemsComputer instanceof SimpleItem) {
                            float randomAttackComp = getRandom0to1();
                            attackComputer = heroComputer.getSkillAttack() * ((SimpleItem) itemsComputer).getDamage()
                                    * randomAttackComp;
                        }
                        if (attackComputer > defenseGamer) {
                            heroGamer.setHp(heroGamer.getHp() - (attackComputer - defenseGamer));
                        }
                        break;
                    case DEFENSE:
                        break;
                }
            }
        }
        saveStepResult();
    }

    private static float getRandom0to1(){
        float random = (int)(Math.round(new Random().nextFloat() * 10));
        return random / 10;
    }
}

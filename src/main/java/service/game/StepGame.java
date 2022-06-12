package service.game;

import java.io.IOException;
import java.util.Random;
import model.Hero;
import model.ItemCategory;
import model.SimpleItem;
import service.file.FileService;
import service.file.TextFileService;
import service.io.ConsoleMassageService;
import service.parser.JsonParserService;


/**
 * Основной класс действий шага игры.
 */
public class StepGame {

    private static final ConsoleMassageService consoleMassageService = ConsoleMassageService.getInstance();

    private final StateStepGame stateStepGame = StateStepGame.getInstance();

    /**
     * Печать выбора артефакта и действия игрока.
     */
    public void printStepSelectGamer() {
        consoleMassageService.print("Вы выбрали: "
                + stateStepGame.getItemsGamer().toString() + ". Действие: "
                + stateStepGame.getActionGamer().getName(), ConsoleMassageService.Color.GREEN);
    }

    /**
     * Печать выбора артефакта и действия компьютера.
     */
    public void printStepSelectComputer() {
        consoleMassageService.print("Компьютер выбрал: "
                + stateStepGame.getItemsComputer().toString() + ". Действие: "
                + stateStepGame.getActionComputer().getName(), ConsoleMassageService.Color.PURPLE);
    }

    /**
     * Печать результата битвы (остаток жизней).
     */
    public void printStepResult() {
        consoleMassageService.print("Результаты битвы:");
        consoleMassageService.print("Осталось жизней у вас: " + stateStepGame.getHeroGamer().getHp());
        consoleMassageService.print("Осталось жизней у компьютера: " + stateStepGame.getHeroComputer().getHp());
    }

    private void saveStepResult() {
        try {
            new TextFileService().writeTextToFile(FileService.saveDirectory, FileService.saveHeroGamerFile,
                    new JsonParserService().parseHeroToString(stateStepGame.getHeroGamer()));
            new TextFileService().writeTextToFile(FileService.saveDirectory, FileService.saveHeroComputerFile,
                    new JsonParserService().parseHeroToString(stateStepGame.getHeroComputer()));
        } catch (IOException e) {
            ConsoleMassageService.getInstance().print(e.getMessage());
        }
    }

    /**
     * Шаг атаки между героями. Расчет остатка жизней.
     */
    public void fight() {
        switch (stateStepGame.getActionGamer()) {
            case ATTACK -> {
                float attackGamer = 0;
                if (stateStepGame.getItemsGamer().getCategory() == ItemCategory.SIMPLE) {
                    attackGamer = calculateResult(stateStepGame.getHeroGamer().getSkillAttack(),
                            ((SimpleItem) stateStepGame.getItemsGamer()).getDamage());
                }
                switch (stateStepGame.getActionComputer()) {
                    case ATTACK -> {
                        float attackComputer = 0;
                        if (stateStepGame.getItemsComputer().getCategory() == ItemCategory.SIMPLE) {
                            attackComputer = calculateResult(stateStepGame.getHeroComputer().getSkillAttack(),
                                    ((SimpleItem) stateStepGame.getItemsComputer()).getDamage());
                        }
                        setHp(stateStepGame.getHeroComputer(), attackGamer);
                        setHp(stateStepGame.getHeroGamer(), attackComputer);
                    }
                    case DEFENSE -> {
                        float defenseComputer = 0;
                        if (stateStepGame.getItemsComputer().getCategory() == ItemCategory.SIMPLE) {
                            defenseComputer = calculateResult(stateStepGame.getHeroComputer().getSkillDefense(),
                                    ((SimpleItem) stateStepGame.getItemsComputer()).getDefense());
                        }
                        if (attackGamer > defenseComputer) {
                            setHp(stateStepGame.getHeroComputer(), attackGamer);
                        }
                    }
                    default -> {
                        ConsoleMassageService.getInstance().print("Выбрано неизвестное действие");
                    }
                }
            }
            case DEFENSE -> {
                float defenseGamer = 0;
                if (stateStepGame.getItemsGamer().getCategory() == ItemCategory.SIMPLE) {
                    defenseGamer = calculateResult(stateStepGame.getHeroGamer().getSkillDefense(),
                            ((SimpleItem) stateStepGame.getItemsGamer()).getDefense());
                }
                switch (stateStepGame.getActionComputer()) {
                    case ATTACK:
                        float attackComputer = 0;
                        if (stateStepGame.getItemsComputer().getCategory() == ItemCategory.SIMPLE) {
                            attackComputer = calculateResult(
                                    stateStepGame.getHeroComputer().getSkillAttack(),
                                    ((SimpleItem) stateStepGame.getItemsComputer()).getDamage());
                        }
                        if (attackComputer > defenseGamer) {
                            setHp(stateStepGame.getHeroGamer(), attackComputer);
                        }
                        break;
                    case DEFENSE:
                        break;
                    default:
                        ConsoleMassageService.getInstance().print("Выбрано неизвестное действие");
                        break;
                }
            }
            default -> {
                ConsoleMassageService.getInstance().print("Выбрано неизвестное действие");
            }
        }
        saveStepResult();
    }

    private void setHp(Hero hero, float attack) {
        hero.setHp(hero.getHp() - attack);
        if (hero.getHp() < 0) {
            hero.setHp(0);
        }
    }

    private float calculateResult(float skillHero, float powerItem) {
        float result = (int) (Math.round(skillHero * powerItem * getRandom0to1() * 10));
        return result / 10;
    }

    private float getRandom0to1() {
        float random = (int) (Math.round(new Random().nextFloat() * 10));
        return random / 10;
    }
}

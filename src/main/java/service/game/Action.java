package service.game;

/**
 * Перечисление доступных действий на шаге игры.
 */
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

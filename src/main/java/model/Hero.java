package model;

import java.util.Objects;

/**
 * Класс героя.
 */
public class Hero {

    private String type;
    private float hp;
    private float skillAttack;
    private float skillDefense;

    /**
     * Создание героя.
     *
     * @param type         - название героя
     * @param skillAttack  - скилл атаки героя
     * @param skillDefense - скилл защиты героя
     */
    public Hero(String type, float skillAttack, float skillDefense) {
        this.type = type;
        this.hp = 100;
        this.skillDefense = skillDefense;
        this.skillAttack = skillAttack;
    }

    /**
     * Создание героя.
     *
     * @param type         - название героя
     * @param hp           - здоровье героя
     * @param skillAttack  - скилл атаки героя
     * @param skillDefense - скилл защиты героя
     */
    public Hero(String type, float hp, float skillAttack, float skillDefense) {
        this.type = type;
        this.hp = hp;
        this.skillDefense = skillDefense;
        this.skillAttack = skillAttack;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getSkillAttack() {
        return skillAttack;
    }

    public void setSkillAttack(float skillAttack) {
        this.skillAttack = skillAttack;
    }

    public float getSkillDefense() {
        return skillDefense;
    }

    public void setSkillDefense(float skillDefense) {
        this.skillDefense = skillDefense;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Герой: "
                + "Персонаж = '" + type + '\''
                + ", Жизни = " + hp
                + ", Навык атаки = " + skillAttack
                + ", Навык защиты = " + skillDefense
                + ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hero hero = (Hero) o;
        return Float.compare(hero.hp, hp) == 0
                && Float.compare(hero.skillAttack, skillAttack) == 0
                && Float.compare(hero.skillDefense, skillDefense) == 0
                && Objects.equals(type, hero.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, hp, skillAttack, skillDefense);
    }
}

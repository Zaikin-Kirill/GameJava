package model;

import java.util.Objects;

/**
 * Класс артефакта.
 */
public class SimpleItem extends Item {

    private float damage;
    private float defense;

    /**
     * Создание артефакта.
     *
     * @param type     название артефакта
     * @param damage   урон артефакта
     * @param defense  защита артефакта
     */
    public SimpleItem(String type, float damage, float defense) {
        super(type);
        this.damage = damage;
        this.defense = defense;
        this.category = ItemCategory.SIMPLE;
    }

    public float getDamage() {
        return damage;
    }


    public float getDefense() {
        return defense;
    }


    @Override
    public String toString() {
        return "Артефакт: "
                + "Название = " + super.getType()
                + ", Урон = " + damage
                + ", Защита = " + defense
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
        if (!super.equals(o)) {
            return false;
        }
        SimpleItem item = (SimpleItem) o;
        return Float.compare(item.damage, damage) == 0 && Float.compare(item.defense, defense) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), damage, defense);
    }
}

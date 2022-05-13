package model;

import java.util.Objects;

public class SimpleItem extends Item {

    private float damage;
    private float defense;

    public SimpleItem(String name, float damage, float defense){
        super(name);
        this.damage = damage;
        this.defense = defense;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Артефакт: " +
                "Название = " + super.getName() +
                ", Урон = " + damage +
                ", Защита = " + defense +
                ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleItem item = (SimpleItem) o;
        return Float.compare(item.damage, damage) == 0 && Float.compare(item.defense, defense) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), damage, defense);
    }
}

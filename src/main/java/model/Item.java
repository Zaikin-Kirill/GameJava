package model;

import java.util.Objects;

/**
 * Абстрактный класс артефакта.
 */
public abstract class Item {

    private String type;


    public Item(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Артефакт: "
                + "Название = '" + type + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(type, item.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}

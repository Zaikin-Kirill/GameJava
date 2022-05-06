package Model;

import java.util.Objects;

public class Hero {

    private  String name;
    private float hp;
    private float skillAttack;
    private float skillDefense;

    public Hero(String name, float skillAttack, float skillDefense){
        this.name = name;
        this.hp = 100;
        this.skillDefense = skillDefense;
        this.skillAttack = skillAttack;
    }
    public Hero(String name, float hp, float skillAttack, float skillDefense){
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Герой: " +
                "Имя = '" + name + '\'' +
                ", Жизни = " + hp +
                ", Навык атаки = " + skillAttack +
                ", Навык защиты = " + skillDefense +
                ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Float.compare(hero.hp, hp) == 0 && Float.compare(hero.skillAttack, skillAttack) == 0 && Float.compare(hero.skillDefense, skillDefense) == 0 && Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hp, skillAttack, skillDefense);
    }
}

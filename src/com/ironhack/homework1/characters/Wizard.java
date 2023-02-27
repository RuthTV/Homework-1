package com.ironhack.homework1.characters;

public class Wizard extends Character {
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.setMana(mana);
        this.setIntelligence(intelligence);
        this.setHp(hp);
    }

    public void setHp(int hp) {
        super.setHp(hp);
        if (hp > 100){
            this.hp = 100;
        } else if (hp <= 0) {
            isAlive = false;
            this.hp = 0;
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
        if (mana > 50){
            this.mana = 50;
        }
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
        if (intelligence > 50){
            this.intelligence = 50;
        }
    }

    public void attack(Character enemy) throws InterruptedException {
        Thread.sleep(1000);
        int damage = 0;
        int enemyHp = enemy.getHp();
        if (mana >= 5){ //Fireball
            damage = intelligence;
            mana -= 5;
            enemyHp -= damage;
            enemy.setHp(enemyHp);

            System.out.println(name + " has cast a Fireball and now " + enemy.getName()
                    + "'s HP is : " + enemy.getHp());

        } else{ //Staff hit
            damage = 2;
            mana++;
            enemyHp -= damage;
            enemy.setHp(enemyHp);

            System.out.println(name + " has done a Staff hit and now " + enemy.getName()
                    + "'s HP is : " + enemy.getHp());
        }
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", Wizard," +
                " name='" + name + '\'' +
                ", hp=" + hp +
                ", mana=" + mana +
                ", intelligence=" + intelligence;
//        return "Wizard{" +
//                "mana=" + mana +
//                ", intelligence=" + intelligence +
//                ", id=" + id +
//                ", name='" + name + '\'' +
//                ", hp=" + hp +
//                ", isAlive=" + isAlive +
//                '}';
    }
}

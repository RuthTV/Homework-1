package com.ironhack.homework1.characters;

public class Warrior extends Character{
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.setStamina(stamina);
        this.setStrength(strength);
        this.setHp(hp);
    }

    public void setHp(int hp) {
        super.setHp(hp);
        if (hp > 200){
            this.hp = 200;
        } else if (hp <= 0) {
            this.hp = 0;
            isAlive = false;
        }
    }
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
        if (stamina > 50){
            this.stamina = 50;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
        if (strength > 10){
            this.strength = 10;
        }
    }

    public void attack(Character enemy) throws InterruptedException {
        Thread.sleep(1000);
        int damage = 0;
        int enemyHp = enemy.getHp();
        if (stamina >= 5){ //Heavy attack
            damage = strength;
            stamina -= 5;
            enemyHp -= damage;
            enemy.setHp(enemyHp);

            System.out.println(name + " has done a Heavy attack and now " + enemy.getName()
                    + "'s HP is : " + enemy.getHp());

        } else{ //Weak attack
            damage = strength/2;
            stamina++;
            enemyHp -= damage;
            enemy.setHp(enemyHp);

            System.out.println(name + " has done a Weak attack and now " + enemy.getName()
                    + "'s HP is : " + enemy.getHp());
        }
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", Warrior," +
                " name='" + name + '\'' +
                ", hp=" + hp +
                ", stamina=" + stamina +
                ", strength=" + strength;

//        return "Warrior{" +
//                "stamina=" + stamina +
//                ", strength=" + strength +
//                ", id=" + id +
//                ", name='" + name + '\'' +
//                ", hp=" + hp +
//                ", isAlive=" + isAlive +
//                '}';
    }
}

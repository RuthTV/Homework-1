package com.ironhack.homework1.characters;

import com.ironhack.homework1.interfaces.Attacker;

import java.util.ArrayList;

public abstract class Character implements Attacker {
    protected final long id;
    protected static int idCounter = 1;
    protected String name;
    protected int hp;
    protected boolean isAlive;

    public Character(String name, int hp) {
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp<0){
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }




    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                '}';
    }
}

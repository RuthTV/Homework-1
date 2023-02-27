package com.ironhack.homework1.interfaces;

import com.ironhack.homework1.characters.Character;

public interface Attacker {
    void attack(Character enemy) throws InterruptedException;  //resources: stamina/mana  strength: strength/intelligence
    //cuando implementamos esto en una clase los nombres de los parámetros pueden cambiarse
}

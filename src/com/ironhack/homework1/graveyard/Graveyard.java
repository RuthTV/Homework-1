package com.ironhack.homework1.graveyard;

import com.ironhack.homework1.characters.Character;

import java.util.ArrayList;
import java.util.List;

public class Graveyard{

    public static void graves(Character player1, Character player2, List<Character> graveyardList){
        if (!player1.isAlive()) {
            graveyardList.add(player1);
        }
        if (!player2.isAlive()) {
            graveyardList.add(player2);
        }

    }
    public static void printGraves(List<Character> graveyardList){

        System.out.println("\n\n======GRAVEYARD======\n");
        for (Character player : graveyardList){
            System.out.println(player.toString());
        }
    }

}
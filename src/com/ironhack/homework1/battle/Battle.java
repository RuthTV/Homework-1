package com.ironhack.homework1.battle;

import com.ironhack.homework1.characters.Character;
import com.ironhack.homework1.graveyard.Graveyard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Battle {
    public static void battle (ArrayList<Character> party1, ArrayList<Character> party2,boolean computerComputer) throws InterruptedException {
        List<Character> graveyardList = new ArrayList<>();
        System.out.println("\n=== The battle Starts ===\n");
        while(party1.size() > 0 && party2.size() > 0) {

            Thread.sleep(1000);
            System.out.println("\n=== New duel ===\n");
            Character character1 = party2.get(randomInt(0, party2.size() - 1));
            if (!computerComputer){
                character1 = chooseCharacterParty(party1);
            }

            Character character2 = party2.get(randomInt(0, party2.size() - 1));

            duel(character1, character2);
            Graveyard.graves(character1,character2,graveyardList);
            if (!character1.isAlive()){
                removeCharacter(party1, character1);
            }
            if (!character2.isAlive()) {
                removeCharacter(party2, character2);
            }

            Graveyard.printGraves(graveyardList);

        }
        System.out.println("\n=== Battle Result ===\n");
        if(party1.size() <= 0){
            System.out.println("\nPlayer 2 is the winner!\n");
        } else if (party2.size() <= 0) {
            System.out.println("\nPlayer 1 is the winner!\n");
        }
    }

    public static void duel(Character character1, Character character2) throws InterruptedException {
        Thread.sleep(1000);

        System.out.println("\n=== The duel starts ===\n");
        while (character1.isAlive() && character2.isAlive()){
            character1.attack(character2);
            character2.attack(character1);
        }

        Thread.sleep(1000);
        System.out.println("\n=== Duel result ===\n");
        if (!character1.isAlive()){
            if (!character2.isAlive()){
                System.out.println( "No one has won!\n" + character1.getName() + " and " +
                        character2.getName() + " have been removed of the parties and are in the graveyard");
            } else {
                System.out.println( character2.getName() + " has won!\n" + character1.getName() +
                        " has been removed of the party and is in the graveyard\n" + character2.getName() +
                        " goes back to the party");
            }
        } else {
            System.out.println( character1.getName() + " has won!\n" + character2.getName() +
                    " has been removed of the party and is in the graveyard\n" + character1.getName() +
                    " goes back to the party");
        }
    }

    public static Character chooseCharacterParty(ArrayList<Character> party1){
        System.out.println("Choose the id your character: ");
        for (Character character: party1){
            System.out.println(character);
        }
        Scanner scanner = new Scanner(System.in);
        long id = scanner.nextLong();
//        scanner.close();

        return getById(party1,id);
    }

    public static Character getById(ArrayList<Character> party,long id){
        Character choosenCharacter = party.get(0);
        for (Character character: party){
            if (character.getId() == id){
                choosenCharacter = character;
                break;
            }
        }
        return choosenCharacter;
    }

    public static void removeCharacter(ArrayList<Character> party, Character personaje){
        for (int i = 0; i < party.size(); i++){
            if (party.get(i) == personaje){
                party.remove(i);
            }
        }
    }

    public static int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}

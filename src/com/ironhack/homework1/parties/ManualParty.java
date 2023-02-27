package com.ironhack.homework1.parties;

import com.ironhack.homework1.characters.Character;
import com.ironhack.homework1.characters.Warrior;
import com.ironhack.homework1.characters.Wizard;

import java.util.ArrayList;
import java.util.Scanner;

public class ManualParty {
    public static ArrayList<Character> createParty(int size) {
        ArrayList<Character> party = new ArrayList<>();
        for (int i=0; i<size; i++){
            createNewCharacter(party);
        }
        return party;
    }

    private static void createNewCharacter(ArrayList<Character> party) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press [1] to create a new Wizard or [2] to create a new Warrior");
        int selection = scanner.nextInt();
        while (selection != 1 && selection != 2){
            System.out.println("Please, select a valid option: [1] to create a new Wizard or [2] to create a new Warrior");
            selection = scanner.nextInt();
        }

        System.out.println("Introduce the name of your new character");
        String name = scanner.next();

        if (selection == 1){ //Creates a Wizard
            System.out.println("Introduce "  + name + "'s HP (between 50 and 100)" );
            int hp = scanner.nextInt();
            while (hp < 50 || hp > 100){
                System.out.println("HP should be set between 50 and 100. Try again!");
                hp = scanner.nextInt();
            }

            System.out.println("Introduce "  + name + "'s Mana (between 10 and 50)" );
            int mana = scanner.nextInt();
            while (mana < 10 || mana > 50){
                System.out.println("Mana should be set between 10 and 50. Try again!");
                mana = scanner.nextInt();
            }

            System.out.println("Introduce "  + name + "'s Intelligence (between 1 and 50)" );
            int intelligence = scanner.nextInt();
            while (intelligence < 1 || intelligence > 50){
                System.out.println("Intelligence should be set between 1 and 50. Try again!");
                intelligence = scanner.nextInt();
            }

            party.add(new Wizard(name, hp, mana, intelligence));

        }else if (selection==2){ //Creates a Warrior
            System.out.println("Introduce "  + name + "'s HP (between 100 and 200)" );
            int hp = scanner.nextInt();
            while (hp < 100 || hp > 200){
                System.out.println("HP should be set between 100 and 200. Try again!");
                hp = scanner.nextInt();
            }

            System.out.println("Introduce "  + name + "'s Stamina (between 10 and 50)" );
            int stamina = scanner.nextInt();
            while (stamina < 10 || stamina > 50){
                System.out.println("Stamina should be set between 10 and 50. Try again!");
                stamina = scanner.nextInt();
            }

            System.out.println("Introduce "  + name + "'s Strength (between 1 and 10)" );
            int strength = scanner.nextInt();
            while (strength < 1 || strength > 10){
                System.out.println("Strength should be set between 1 and 10. Try again!");
                strength = scanner.nextInt();
            }
            party.add(new Warrior(name, hp, stamina, strength));
        }
    }
}

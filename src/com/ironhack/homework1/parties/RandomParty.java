package com.ironhack.homework1.parties;

import com.ironhack.homework1.characters.Character;
import com.ironhack.homework1.characters.Warrior;
import com.ironhack.homework1.characters.Wizard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomParty {

    public static ArrayList<Character> randomParty(int size) {
        String[] names = {"Lex", "Arya", "Ron", "Legolas", "Luna", "Kira", "Hopper", "Sirius", "Sam", "Ce", "Eragon",
                "Merlin", "Sauron","Maeve","River","Slade","Bjorn","Magnus","Jack","Wesley","Perceval","Gawain","Arthur",
                 "Aragorn","Sora","Hercules","Kahlan"};
        int numWizards = randomInt(1,size);
        int numWarriors = randomInt(1,size);
        int sum = numWarriors+numWizards;
        while (sum != size){
            numWizards = randomInt(1,size);
            numWarriors = randomInt(1,size);
            sum = numWarriors+numWizards;
        }
        String[] usedNames = new String[size];


        ArrayList<Character> party = new ArrayList<>();

        for (int charact=0; charact < size; charact++){

            int nameIndex = randomInt(0, names.length-1);
            String name = names[nameIndex];
            while (Arrays.asList(usedNames).contains(name)){
                name = name.concat(" Jr.");
            }
            usedNames[charact] = name;

            if (numWarriors > 0){
                int hp = randomInt(100,200);
                int stamina = randomInt(10,50);
                int strength = randomInt(1,10);
                party.add(new Warrior(name,hp, stamina, strength));
                numWarriors-=1;

            } else if (numWizards > 0){
                int hp = randomInt(50,100);
                int mana = randomInt(10,50);
                int intelligence = randomInt(1,50);
                party.add(new Wizard(name, hp, mana, intelligence));
                numWizards-=1;
            }
        }

        return party;
    }

    public static int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}

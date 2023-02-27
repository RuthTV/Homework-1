package com.ironhack.homework1.menu;

import com.ironhack.homework1.characters.Character;
import com.ironhack.homework1.parties.RandomParty;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateFile {
    public static void createFile(ArrayList<Character> party1,Scanner scanner) throws IOException, InterruptedException {
        System.out.println("Do you want to save your party in a cvs file?\n"+
                "Press [y] for Yes and [n] for No");
        String saveParty = scanner.next();
        while (!saveParty.equals("y") && !saveParty.equals("n")){
            System.out.println("Please select a valid option");
            saveParty = scanner.next();
        }
        switch (saveParty) {
            case "y":
                downloadTheFile(party1);
                break;
            case "n":
                break;
        }
    }

    public static void downloadTheFile (ArrayList<Character> party) throws IOException {
        FileWriter fileWriter = new FileWriter("Created_Party.csv", false);
        fileWriter.write("Character;"+"Name;"+"Hp;"+"Stamina / Mana;"+"Strength / Intelligence"+"\n");
        for (Character character : party){
            String typeCharacter = character.toString().split(",")[1];
            String staminaMana = character.toString().split(",")[4].toString().split("=")[1];
            String strengthIntelligence = character.toString().split(",")[5].toString().split("=")[1];
            fileWriter.write(typeCharacter+";"+character.getName()+";"+character.getHp()+";"+staminaMana+";"+strengthIntelligence+"\n");
        }
        fileWriter.close();
    }
}

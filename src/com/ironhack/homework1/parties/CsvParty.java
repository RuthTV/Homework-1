package com.ironhack.homework1.parties;

import com.ironhack.homework1.characters.Character;
import com.ironhack.homework1.characters.Warrior;
import com.ironhack.homework1.characters.Wizard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvParty {
    public static ArrayList<Character> csvParty(String nameFile) throws FileNotFoundException {
        ArrayList<Character> party = new ArrayList<>();
        File file = new File(nameFile);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String[] separatedLine=line.split(";");
            if (separatedLine[0].equals("Wizard")){
                party.add(new Wizard(separatedLine[1], Integer.parseInt(separatedLine[2]), Integer.parseInt(separatedLine[3]), Integer.parseInt(separatedLine[4])));
            }else if (separatedLine[0].equals("Warrior")){
                party.add(new Warrior(separatedLine[1], Integer.parseInt(separatedLine[2]), Integer.parseInt(separatedLine[3]), Integer.parseInt(separatedLine[4])));
            }else{
                throw new IllegalArgumentException("The Character doesn't exist");
            }
        }scanner.close();
        return party;

    }

}
package com.ironhack.homework1.menu;

import com.ironhack.homework1.battle.Battle;
import com.ironhack.homework1.characters.Character;
import com.ironhack.homework1.parties.CsvParty;
import com.ironhack.homework1.parties.ManualParty;
import com.ironhack.homework1.parties.RandomParty;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static com.ironhack.homework1.parties.RandomParty.randomInt;

public class Menu {
    public static void menu() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> party1 = new ArrayList<>();
        ArrayList<Character> party2 = new ArrayList<>();
        int size = party1.size();
        boolean computerComputer = false;

        int playMode = selectPlayMode(scanner);
        switch (playMode){
            case 1:
                int partyMode = selectPartyCreationMode(scanner);
                party1 = partyCreation(partyMode,scanner);
                CreateFile.createFile(party1,scanner);
                break;
            case 2:
                size = randomInt(1, 20);
                party1 = RandomParty.randomParty(size);
                computerComputer = true;
                break;
        }
        size = party1.size();
        party2 = RandomParty.randomParty(size);

        startBattle(party1, party2,computerComputer);

        reGame();

        scanner.close();
    }

    public static int selectPlayMode(Scanner scanner) throws IOException, InterruptedException {
        System.out.println(
                        "###############################################################\n" +
                        "#               WELCOME TO EPIC BATTLES                        #\n" +
                        "###############################################################");
        System.out.println("How do you want to play?");
        System.out.println("┎---------------------------------------------┒");
        System.out.println("│[1] Player vs Computer                       │");
        System.out.println("│[2] Computer vs Computer                     │");
        System.out.println("┖---------------------------------------------┚");

        int playerMode = scanner.nextInt();

        while (playerMode != 1 && playerMode != 2) {
            System.out.println("Please select a valid option");
            playerMode = scanner.nextInt();
        }
        return playerMode;
    }

    public static int selectPartyCreationMode(Scanner scanner){
            System.out.println("How do you want to create your party?");
            System.out.println("┎---------------------------------------------┒");
            System.out.println("│[1] Manual Party                             │");
            System.out.println("│[2] Import Party from CSV                    │");
            System.out.println("│[3] Random Party                             │");
            System.out.println("┖---------------------------------------------┚");

            int partyMode = scanner.nextInt();
            while (partyMode != 1 && partyMode != 2 && partyMode != 3) {
                System.out.println("Please select a valid option");
                partyMode = scanner.nextInt();
            }
            return partyMode;
    }

    public static ArrayList<Character> partyCreation(int partyMode,Scanner scanner) throws FileNotFoundException {
        ArrayList<Character> party1 = new ArrayList<>();
        int size = party1.size();
        switch (partyMode) {
            case 1:
                System.out.println("Indicate the size of your party");
                size = scanner.nextInt();
                party1 = ManualParty.createParty(size);
                break;
            case 2:
                System.out.println("Indicate the name of the CSV with your party \n" +
                        "Remember that the name has to include the .csv extension");
                String fileName = scanner.next();
                party1 = CsvParty.csvParty(fileName);
                break;
            case 3:
                System.out.println("Indicate the size of your party");
                size = scanner.nextInt();
                party1 = RandomParty.randomParty(size);
                break;
        }
        return party1;
    }

    public static void startBattle(ArrayList<Character> party1, ArrayList<Character> party2, boolean computerComputer) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press [s] to Start de battle or [q] to Quit the game");
        String start = scanner.next();
        while (!start.equals("s") && !start.equals("q")) {
            System.out.println("Please select a valid option");
            start = scanner.next();
        }
        switch (start) {
            case "s":
                Battle.battle(party1, party2,computerComputer);
                break;
            case "q":
                System.out.println("Good bye!");
                scanner.close();
                System.exit(0);
        }
    }

    public static void reGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to Play Again?\n" +
                "Press [y] for Yes and [n] for No");
        String playAgain = scanner.next();
        while (!playAgain.equals("y") && !playAgain.equals("n")){
            System.out.println("Please select a valid option");
            playAgain = scanner.next();
        }
        switch (playAgain) {
            case "y":
                try {
                    menu();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException | IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "n":
                System.out.println("Good bye!");
                scanner.close();
                System.exit(0);
        }
    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}

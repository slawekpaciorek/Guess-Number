package com.guessNumber_main.gameSettings;

public class GameMenu implements GameExecutor {
    @Override
    public void follow() {

        System.out.println("|---------------------Lucky Numbers---------------------|");
        System.out.println("|                                                       |");
        System.out.println("|\tZasady gry:                                         |");
        System.out.println("|                                                       |");
        System.out.println("|1. Podaj liczbę, większą od 0, określającą zakres gry. |");
        System.out.println("|2. Program losuje liczbę.                              |");
        System.out.println("|3. Spróbuj zgadnąć liczbę jaką wylosował program.      |");
        System.out.println("|4. Masz 5 prób.                                        |");
        System.out.println("|                                                       |");
        System.out.println("|\tJeśli chcesz zacząć grę wpisz : start               |");
        System.out.println("|\tJeśli chcesz zakończyć wpisz : exit                 |");
        System.out.println("|                                                       |");
        System.out.println("|-------------------------------------------------------|");


    }
}

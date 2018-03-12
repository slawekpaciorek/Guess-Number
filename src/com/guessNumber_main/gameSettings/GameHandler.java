package com.guessNumber_main.gameSettings;

import java.util.Scanner;

class GameHandler implements GameExecutor {

    Scanner getInstruction = new Scanner(System.in);

    private int hiddenNumber;
    private boolean gotInt = false;


    private static InstructionOperator instruction = InstructionOperator.init();

    @Override
    public void follow(){

        System.out.print("\tWybierz numer : ");

        while(!gotInt) {
            try {
                getHidden();
                gotInt = true;
            }
            catch (NumberFormatException ex) {
                System.out.println("\tWprowadz poprawnie liczbę, a nie tekst");
                instruction.follow("start");
            }
        }

        gotInt = false;

        System.out.print("\tZgadnij wylosowaną liczbę : ");

        while(!gotInt) {
            try {
                luckyNumber();
                gotInt = true;
            } catch (NumberFormatException ex) {
                System.out.println("\tGra uruchomiona jeszcze raz, postępuj zgodnie ze wskazówkami");
                instruction.follow("start");
            }
        }

        System.out.println();
        System.out.print("\tZagrasz jeszcze raz?(tak/nie): ");

        String input = getInstruction.next();

        if(input.equals("nie") || input.equals("exit"))
            input = "nie";
        else if(input.equals("tak"))
            input = "tak";
        else{
            System.out.print("\tBłędna komenda, wybierz jeszcze raz : ");
            input = getInstruction.next();
        }

        gotInt = false;

        System.out.println();
        instruction.follow(input);
        System.out.println();


    }
    protected int getHidden(){
        String rangeS = getInstruction.next();
        int range = Integer.parseInt(rangeS);
        if(range >0)
            return hiddenNumber = (int)(Math.random() * range);
        else {
            System.out.println();
            System.out.println("\tPowinieneś wybrać liczbę większa od 0");
            System.out.print("\tWybierz liczbę : ");
            rangeS = getInstruction.next();
            range = Integer.parseInt(rangeS);
            System.out.println();
            return hiddenNumber = (int) (Math.random() * range);
        }
    }
    protected void luckyNumber(){
        for (int i = 1; i <= 5; i++) {
            String luckyNumberString = getInstruction.next();
            int luckyNumber = Integer.parseInt(luckyNumberString);
            if (hiddenNumber == luckyNumber) {
                System.out.println();
                System.out.println("\t!!!! Super wygrałeś !!!!");
                System.out.println();
                break;
            } else if (i + 1 <= 5) {
                System.out.print("\tWybierz jeszcze raz, to jest twoja " + (i + 1) + " próba: ");
            } else {
                System.out.println();
                System.out.println("\tNiestety przegrałeś, wylosowana liczba to : " + hiddenNumber);
            }
        }
    }


}

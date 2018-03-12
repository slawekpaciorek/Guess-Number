package com.guessNumber_main;

import java.util.Scanner;
import com.guessNumber_main.gameSettings.InstructionOperator;



public class Main {

    private static InstructionOperator instruction = InstructionOperator.init();

    public static void main(String[] args) {

        boolean stopPlay = false;
        Scanner getInstruction = new Scanner(System.in);

        while(!stopPlay){

            instruction.follow("menu");

            System.out.print("\tCo zrobisz : ");

            String input;
            input = getInstruction.next();

            stopPlay = input.equals("exit");

            System.out.println();
            instruction.follow(input);
            System.out.println();

        }

        getInstruction.close();
    }
}

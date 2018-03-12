package com.guessNumber_main.gameSettings;

import java.util.Map;
import java.util.HashMap;

public class InstructionOperator {

    private final Map<String, GameExecutor> instruction;

    public static InstructionOperator init() {

        InstructionOperator result = new InstructionOperator();

        result.instruction.put("menu", new GameMenu());
        result.instruction.put("exit", () -> System.out.println("\tDziękuję za grę"));
        result.instruction.put("error", () -> System.out.println("\tBłędna komenda, gra uruchomi się jeszcze raz."));
        result.instruction.put("start", new GameHandler());
        result.instruction.put("tak", new GameHandler());
        result.instruction.put("nie", () -> System.out.println("\tPowrót do głównego menu"));

        return result;
    }

    private InstructionOperator() {
        instruction = new HashMap<>();
    }
    public void follow(String name){
        //Unknow instruction
        if(!instruction.containsKey(name)){
            name = "error";
        }

        instruction.get(name).follow();
    }
}

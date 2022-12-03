package day2;

import day1.Elf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) throws IOException {
        File file = new File(Day2.class.getResource("input.txt").getFile());
        if(file.exists())
        {
            FileInputStream fr = new FileInputStream(file);
            StringBuilder content = new StringBuilder();
            int i;
            while((i=fr.read())!=-1)
            {
                content.append((char) i);
            }

            String[] lines = content.toString().split("\\r?\\n");

            //part1

            int points = 0;

            for (String line : lines) {
                String player = line.split(" ")[1];
                String opposent = line.split(" ")[0];

                EnumGameState gameState = getGameState(EnumRPS.getEnumFromInterpretOpposent(opposent),EnumRPS.getEnumFrominterpretPlayer(player));
                points += gameState.point + EnumRPS.getEnumFrominterpretPlayer(player).point;
            }

            System.out.println("Points : " + points);

            //Part2

            int PointToMatchInput = 0;
            for (String line : lines) {
                String opposentRPS = line.split(" ")[0];
                String endGame = line.split(" ")[1];

                EnumGameState state = EnumGameState.getEnumFromInterpret(endGame);
                EnumRPS rps = getRPSFromGameState(state, EnumRPS.getEnumFromInterpretOpposent(opposentRPS));
                PointToMatchInput += rps.point + state.point;
            }
            System.out.println("PointToMatchInput : " + PointToMatchInput);
        }
    }

    public static EnumGameState getGameState(EnumRPS input1, EnumRPS input2)
    {
        if(input1.equals(input2))
            return EnumGameState.DRAW;
        if(input1.equals(EnumRPS.ROCK))
        {
            if(input2.equals(EnumRPS.PAPER))
                return EnumGameState.WIN;
            if(input2.equals(EnumRPS.SCISSORS))
                return EnumGameState.LOSE;
        }
        if(input1.equals(EnumRPS.PAPER))
        {
            if(input2.equals(EnumRPS.ROCK))
                return EnumGameState.LOSE;
            if(input2.equals(EnumRPS.SCISSORS))
                return EnumGameState.WIN;
        }
        if(input1.equals(EnumRPS.SCISSORS))
        {
            if(input2.equals(EnumRPS.ROCK))
                return EnumGameState.WIN;
            if(input2.equals(EnumRPS.PAPER))
                return EnumGameState.LOSE;
        }
        return EnumGameState.LOSE;
    }

    public static EnumRPS getRPSFromGameState(EnumGameState gameState, EnumRPS fight)
    {
        if(gameState.equals(EnumGameState.WIN))
        {
            if(fight.equals(EnumRPS.ROCK))
                return EnumRPS.PAPER;
            if(fight.equals(EnumRPS.PAPER))
                return EnumRPS.SCISSORS;
            if(fight.equals(EnumRPS.SCISSORS))
                return EnumRPS.ROCK;
        }
        if(gameState.equals(EnumGameState.LOSE))
        {
            if(fight.equals(EnumRPS.ROCK))
                return EnumRPS.SCISSORS;
            if(fight.equals(EnumRPS.PAPER))
                return EnumRPS.ROCK;
            if(fight.equals(EnumRPS.SCISSORS))
                return EnumRPS.PAPER;
        }
        else if(gameState.equals(EnumGameState.DRAW))
            return fight;
        return null;
    }
}
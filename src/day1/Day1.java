package day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Day1 {
    public static void main(String[] args) throws IOException {
        File file = new File(Day1.class.getResource("input.txt").getFile());
        if(file.exists())
        {
            FileInputStream fr = new FileInputStream(file);
            StringBuilder content = new StringBuilder();
            int i;
            while((i=fr.read())!=-1)
            {
                content.append((char) i);
            }

            ArrayList<Elf> elves = new ArrayList<>();
            String[] lines = content.toString().split("\\r?\\n");
            ArrayList<Integer> currentCaloriesForElf = new ArrayList<>();
            for (String line : lines) {
                if(line.equals(""))
                {
                    elves.add(new Elf(currentCaloriesForElf.stream().mapToInt(Integer::intValue).toArray()));
                    currentCaloriesForElf.clear();
                }
                else
                    currentCaloriesForElf.add(Integer.parseInt(line));
            }

            elves.sort((o1, o2) -> o2.getCaloriesSum() - o1.getCaloriesSum());
            System.out.println("L'elf avec le plus de calories : " + elves.get(0).getCaloriesSum());
        }
    }
}
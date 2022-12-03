package day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day3 {

    private static ArrayList<Character> alphabet = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File file = new File(Day3.class.getResource("input2.txt").getFile());
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

            alphabet.addAll(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));

            int pointCount = 0;
            for (String line : lines) {
                String part1 = line.substring(0,line.length()/2);
                String part2 = line.substring(line.length()/2);

                char[] part1Array = part1.toCharArray();
                char[] part2Array = part2.toCharArray();

                ArrayList<Character> part2list = new ArrayList<>();
                for (char c : part2Array) {
                    part2list.add(c);
                }

                //find the same char
                for (char c : part1Array) {
                    if(part2list.stream().anyMatch(c1 -> c1 == c))
                    {
                        System.out.println("char : " + c);
                        pointCount += (Character.isUpperCase(c) ? 27 : 1) + alphabet.indexOf(Character.toLowerCase(c));
                        break;
                    }
                }
            }

            System.out.println("Point : " + pointCount);

            //part2
            pointCount = 0;

            for (int i1 = 0; i1 < lines.length; i1+=3) {
                String line1 = lines[i1];
                String line2 = lines[i1+1];
                String line3 = lines[i1+2];

                List<Character> line1List = new ArrayList<>();
                for (char c : line1.toCharArray()) {
                    if(!line1List.contains(c))
                        line1List.add(c);
                }
                List<Character> line2List = new ArrayList<>();
                for (char c : line2.toCharArray()) {
                    if(!line2List.contains(c))
                        line2List.add(c);
                }
                List<Character> line3List = new ArrayList<>();
                for (char c : line3.toCharArray()) {
                    if(!line3List.contains(c))
                        line3List.add(c);
                }

                ArrayList<Character> linesList = new ArrayList<>();
                linesList.addAll(line1List);
                linesList.addAll(line2List);
                linesList.addAll(line3List);

                //if linelist contain a common char
                for (char c : linesList) {
                    if(line1List.contains(c) && line2List.contains(c) && line3List.contains(c))
                    {
                        System.out.println("char : " + c);
                        pointCount += (Character.isUpperCase(c) ? 27 : 1) + alphabet.indexOf(Character.toLowerCase(c));
                        break;
                    }
                }
            }
            System.out.println("Point : " + pointCount);

        }
    }
}
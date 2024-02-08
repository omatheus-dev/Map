package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {

    public static void main(String[] args) {

        String path = "c:/Java/in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            Map<String, Integer> map = new LinkedHashMap<>();

            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(", ");
                String name = fields[0];
                int qtndVotes = Integer.parseInt(fields[1]);

                if(map.containsKey(name)) {
                    int votesSoFar = map.get(name);
                    map.put(name, qtndVotes +votesSoFar);
                } else {
                    map.put(name, qtndVotes);
                }

                line = br.readLine();
            }

            for (String key : map.keySet()) {
                System.out.println(key + ", " + map.get(key));
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}

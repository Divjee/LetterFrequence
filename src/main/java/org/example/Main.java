package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("sample-text-file.txt"));

        StringBuilder builtText = new StringBuilder();
        String a;
        while ((a = br.readLine()) != null) {
            builtText.append(a);
        }
        br.close();

        String[] p = builtText.toString().split("");
        String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        HashMap<String, Integer> map = new HashMap<>();
        int counter = 0;
        double counter2 = 0;
        for (String s : abc) {
            for (String value : p) {
                if (s.equalsIgnoreCase(value)) {
                    counter++;
                }
            }
            counter2 += counter;
            map.put(s.toUpperCase(), counter);
            counter = 0;
        }

        for (String key : map.keySet()) {
            System.out.println(key + " occurs: " + (double) Math.round(((map.get(key) / counter2) * 100) * 100) / 100 + "%");
        }


    }
}
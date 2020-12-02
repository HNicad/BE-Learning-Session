package com.nijad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> a = (ArrayList<Integer>) Arrays
                .stream(scanner.nextLine().split(" "))
                .map(e -> Integer.valueOf(e))
                .collect(Collectors.toList());
        ArrayList<Integer> b = (ArrayList<Integer>) Arrays
                .stream(scanner.nextLine().split(" "))
                .map(e -> Integer.valueOf(e))
                .collect(Collectors.toList());
        int alice = 0, bob = 0;
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) > b.get(i)){
                ++alice;
            }
            if(a.get(i) < b.get(i)){
                ++bob;
            }
        }
        System.out.println(alice + " " + bob);
    }
}

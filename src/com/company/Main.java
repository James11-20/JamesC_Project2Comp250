package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //TODO: change these to change the likelihood of a random Package shipping economy, priority, or overnight.
        //TODO: Make sure these total 100 or chanceArray will have null values in it (which would crash the program if accessed).
        int economyChance = 50, priorityChance = 30, overnightChance = 20;

        //TODO: Use this later to determine which type of shipping each package has.
        String[] chanceArray = fillArray(economyChance, priorityChance, overnightChance);
        //TODO: Use this later to determine which random description is used for each new package.
        String[] descriptionsArray = readDescriptions();

        //TODO: Steps 2+3 here go here.
        int timer = 0;
        int timeLimit = 100;
        Random name = new Random();
        Random weight = new Random();
        Random shipping = new Random();
        PackageQueue economyShipping = new PackageQueue();
        PackageQueue priorityShipping = new PackageQueue();
        PackageQueue overnightShipping = new PackageQueue();
        while (timer<timeLimit){
            int ship = shipping.nextInt(chanceArray.length);
            int lb = weight.nextInt(100)+1;
            int itemNum = name.nextInt(descriptionsArray.length);
            if(chanceArray[ship].equals("economy")){
                economyShipping.enqueue(new Package(descriptionsArray[itemNum],lb,null));
                if(timer%10 ==0){
                    System.out.println(economyShipping.peek());
                }
            }
            else if(chanceArray[ship].equals("priority")){
                priorityShipping.enqueue(new Package(descriptionsArray[itemNum],lb,null ));
                if(timer%10 ==0){
                    System.out.println(priorityShipping.peek());
                }
            }
            else if(chanceArray[ship].equals("overnight")){
                overnightShipping.enqueue(new Package(descriptionsArray[itemNum],lb,null));
                if(timer%10 ==0){
                    System.out.println(overnightShipping.peek());
                }
            }
            ++timer;
        }
        System.out.println("Economy size: " + economyShipping.size);
        System.out.println("Priority size: " + priorityShipping.size);
        System.out.println("OverNight size: " + overnightShipping.size);
    }

    public static String[] fillArray(int economyChance, int priorityChance, int overnightChance) {
        //TODO: This is explained in step 0. You don't need to modify this method at all.
        //TODO: If wanted, you can uncomment the for loop below to see the contents of the array this method makes.
        String[] chanceArray = new String[100];
        int arrayPointer = 0;
        Arrays.fill(chanceArray, arrayPointer, arrayPointer + economyChance, "economy");
        arrayPointer += economyChance;
        Arrays.fill(chanceArray, arrayPointer, arrayPointer + priorityChance, "priority");
        arrayPointer += priorityChance;
        Arrays.fill(chanceArray, arrayPointer, arrayPointer + overnightChance, "overnight");

      //  for(String shipMethod : chanceArray) {
      //      System.out.print(shipMethod + " -> ");
      //  }
      // System.out.println("end");

        return chanceArray;
    }

    public static String[] readDescriptions() {
        //TODO: This is explained in step 0. You don't need to modify this method at all.
        String[] descriptions = new String[50];

        try {
            Scanner file = new Scanner(new File("src/com/company/descriptions.txt"));
            for (int i = 0; i < 50; ++i) {
                descriptions[i] = file.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        }

        return descriptions;
    }
}
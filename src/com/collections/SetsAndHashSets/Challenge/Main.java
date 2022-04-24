package com.collections.SetsAndHashSets.Challenge;

public class Main {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");
        System.out.println(rover2.equals(rover));//labrodor is instance of dog
        System.out.println(rover.equals(rover2));//dog isn't instance of labrador
    }
}

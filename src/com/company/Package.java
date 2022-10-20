package com.company;

public class Package {
    public String description;
    public int weight = 0;
    Package next;

    public Package(String newDescription, int newWeight,Package newNext) {
        description = newDescription;
        weight = newWeight;
        next = newNext;
    }

    @Override
    public String toString() {
        return "Package Contents: "+ description +
                " (" + weight + "lbs).";
    }
}

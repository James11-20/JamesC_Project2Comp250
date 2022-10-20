package com.company;

import java.util.NoSuchElementException;

//TODO: Any errors in this class regarding the .next references should clear up once you fill in Package.java
//TODO:   in step 1. If not, let me know and I can take a look at what you've done.
public class PackageQueue {
    Package front;
    Package back;
    int size;

    public PackageQueue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public void clear() {
        front = null;
        back = null;
        size = 0;
    }

    public void enqueue(Package newPackage) {
        if (size == 0) {
            //If empty, the new package is both the front and back now.
            back = newPackage;
            front = back;
        } else {
            //If non-empty, the new package becomes the new back after.
            back.next = newPackage;
            back = back.next;
        }
        ++size; //Either way, we will successfully add a package, so deferring this until here saves a line.
    }

    public Package peek() {
        if (size == 0) {
            return null;
        } else {
            return back;
        }
    }

    public Package dequeue() {
        Package toReturn;
        if (size == 0) {
            throw new NoSuchElementException("This queue is empty!");
        } else if (size == 1) {
            toReturn = front;
            clear();
        } else {
            toReturn = front;
            front = front.next;
            --size;
        }
        return toReturn;
    }
}
package com.company;

public class Main {
    public static void main(String[] args) {
        int threadCount = 5;
        int step = 2; // крок послідовності

        BreakThread breakThread = new BreakThread(threadCount);

        for (int i = 1; i <= threadCount; i++) {
            new MainThread(i, breakThread, step).start();
        }

        new Thread(breakThread).start();
    }
}

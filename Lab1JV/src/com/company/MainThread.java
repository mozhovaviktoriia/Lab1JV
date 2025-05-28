package com.company;

public class MainThread extends Thread {
    private final int id;
    private final BreakThread breakThread;
    private final int step;

    public MainThread(int id, BreakThread breakThread, int step) {
        this.id = id;
        this.breakThread = breakThread;
        this.step = step;
    }

    @Override
    public void run() {
        long sum = 0;
        long count = 0;
        int current = 0;

        while (!breakThread.canBreak(id)) {
            sum += current;
            count++;
            current += step;
        }

        System.out.println("Thread " + id + ": Sum = " + sum + ", Count = " + count);
    }
}

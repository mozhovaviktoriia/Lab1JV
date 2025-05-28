package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class BreakThread implements Runnable {
    private final AtomicBoolean[] permissions;

    public BreakThread(int threadCount) {
        permissions = new AtomicBoolean[threadCount];
        for (int i = 0; i < threadCount; i++) {
            permissions[i] = new AtomicBoolean(false);
        }
    }

    @Override
    public void run() {
        try {
            // Через кожні 5 секунд даємо дозвіл одному потоку
            for (int i = 0; i < permissions.length; i++) {
                Thread.sleep(5000);
                permissions[i].set(true);
                System.out.println("Permission given to thread " + (i + 1));
            }
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

    }

    public boolean canBreak(int threadId) {
        return permissions[threadId - 1].get();
    }
}

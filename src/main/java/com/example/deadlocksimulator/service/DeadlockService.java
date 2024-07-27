package com.example.deadlocksimulator.service;
import org.springframework.stereotype.Service;

@Service
public class DeadlockService {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void simulateDeadlock() {
        // Starting two threads that will deadlock
        Thread thread1 = new Thread(this::task1);
        Thread thread2 = new Thread(this::task2);

        thread1.start();
        thread2.start();
    }

    private void task1() {
        synchronized (lock1) {
            try {
                // Simulate some work
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (lock2) {
                // Critical section
                System.out.println("Thread 1 acquired both locks.");
            }
        }
    }
    private void task2() {
        synchronized (lock2) {
            try {
                // Simulate some work
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (lock1) {
                // Critical section
                System.out.println("Thread 2 acquired both locks.");
            }
        }
    }
}

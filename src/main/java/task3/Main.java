package task3;

import java.util.concurrent.CountDownLatch;

public class Main {
    /**
     * 3 бегуна должны прийти к старту гонки
     * Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
     * Программа должна отсчитать “На старт”, “Внимание”, “Марш”
     * Программа должна завершиться когда все участники закончат гонку.
     * Подумайте об использовании примитива синхронизации
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch allStart = new CountDownLatch(3);
        CountDownLatch startRase = new CountDownLatch(1);
        Thread runner1 = new Thread(new Runner(allStart, startRase));
        Thread runner2 = new Thread(new Runner(allStart, startRase));
        Thread runner3 = new Thread(new Runner(allStart, startRase));
        runner1.start();
        runner2.start();
        runner3.start();
        allStart.await();
        System.out.println("На старт! Внимание! Марш!");
        startRase.countDown();
        runner1.join();
        runner2.join();
        runner3.join();
    }
}

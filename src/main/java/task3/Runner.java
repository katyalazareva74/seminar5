package task3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable{
    CountDownLatch redyToStart;
    CountDownLatch raseToStart;
    Runner(CountDownLatch redy, CountDownLatch rase){
        this.redyToStart=redy;
        this.raseToStart=rase;
    }
    @Override
    public void run() {
        System.out.println("Жду на старте"+Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(2000));
            redyToStart.countDown();
            raseToStart.await();
            System.out.println("Бегу"+Thread.currentThread().getName());
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("Прибежал "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
